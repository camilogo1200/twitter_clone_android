package com.example.mptwitterclone.feed.data.adapters.network.services

import com.example.mptwitterclone.feed.data.adapters.network.dto.TweetDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface TweeterApi {
    @GET("/")
    @Headers("X-Api-Key:PMAK-62fce1e5eb47f551fe7a3ec4-ed7d62898bb836120a52b561a6b867e274")
    suspend fun getUserTimeLine(): Response<List<TweetDto>>
}
