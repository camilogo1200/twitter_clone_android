package com.example.mptwitterclone.feed.data.adapters.persistence.repositories

import com.example.mptwitterclone.feed.domain.models.Tweet

class FakeTimelineRepositoryImpl : TimelineRepository {
    override suspend fun invoke(): Result<List<Tweet>> {
        return Result.success(listOf())
    }
}
