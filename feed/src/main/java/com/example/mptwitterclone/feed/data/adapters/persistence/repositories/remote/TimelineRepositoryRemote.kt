package com.example.mptwitterclone.feed.data.adapters.persistence.repositories.remote

import com.example.mptwitterclone.common.coroutines.di.IoDispatcher
import com.example.mptwitterclone.feed.data.adapters.network.services.TweeterApi
import com.example.mptwitterclone.feed.data.adapters.persistence.repositories.TimelineRepository
import com.example.mptwitterclone.feed.domain.models.Tweet
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TimelineRepositoryRemote @Inject constructor(
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
    private val tweeterService: TweeterApi
) : TimelineRepository {
    override suspend fun invoke(): Result<List<Tweet>> {
        return withContext(coroutineDispatcher) {
            val timelineResponse = tweeterService.getUserTimeLine()
            if (timelineResponse.isSuccessful) {
                val tweets = timelineResponse.body() ?: listOf()
                Result.success(tweets.map { it.toModel() })
            } else {
                Result.failure(Error(timelineResponse.message()))
            }
        }
    }
}
