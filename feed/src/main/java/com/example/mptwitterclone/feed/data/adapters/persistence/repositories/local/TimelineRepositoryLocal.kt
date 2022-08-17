package com.example.mptwitterclone.feed.data.adapters.persistence.repositories.local

import com.example.mptwitterclone.feed.data.adapters.persistence.repositories.TimelineRepository
import com.example.mptwitterclone.feed.domain.models.Tweet
import javax.inject.Inject

class TimelineRepositoryLocal @Inject constructor() : TimelineRepository {
    override suspend fun invoke(): Result<List<Tweet>> {
        TODO("Not yet implemented")
    }
}
