package com.example.mptwitterclone.feed.data.adapters.persistence.repositories

import com.example.mptwitterclone.feed.domain.models.Tweet

interface TimelineRepository {
    suspend fun invoke(): Result<List<Tweet>>
}
