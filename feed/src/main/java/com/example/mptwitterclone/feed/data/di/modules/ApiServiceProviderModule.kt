package com.example.mptwitterclone.feed.data.di.modules

import com.example.mptwitterclone.feed.data.adapters.network.services.TweeterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceProviderModule {

    //private const val API_URL = "https://api.twitterclone.com/"
    private const val API_URL = "https://8edd2337-b309-428f-bb52-b764575d4ea0.mock.pstmn.io" //mock postman

    @Provides
    fun providesTweeterServiceApi(retrofitBuilder: Retrofit.Builder): TweeterApi {
        val retrofit = retrofitBuilder
            .baseUrl(API_URL)
            .build()
        return retrofit.create(TweeterApi::class.java)
    }
}
