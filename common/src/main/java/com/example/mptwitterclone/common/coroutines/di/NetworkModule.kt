package com.example.mptwitterclone.common.coroutines.di

import com.example.mptwitterclone.common.network.INetworkManager
import com.example.mptwitterclone.common.network.LoggingInterceptor
import com.example.mptwitterclone.common.network.NetworkManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val APPLICATION_JSON_MEDIA_TYPE = "application/json"
    private const val CONNECTION_TIMEOUT = 5L
    private const val READ_TIMEOUT = 2L

    @Provides
    fun providesRetrofitClient(
        okHttpclient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .client(okHttpclient)
    }

    private val jsonProperties = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun providesKotlinxConverterFactory(): Converter.Factory {
        val contentType = APPLICATION_JSON_MEDIA_TYPE.toMediaType()
        return jsonProperties.asConverterFactory(contentType)
    }

    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
        builder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        builder.readTimeout(READ_TIMEOUT, TimeUnit.MINUTES)
        return builder.build()
    }

    @Provides
    fun provideInterceptor(): Interceptor {
        return LoggingInterceptor()
    }

    @Provides
    @Singleton
    fun provideNetworkManager(): INetworkManager {
        return NetworkManager()
    }

}
