package com.example.mptwitterclone.feed.domain.use_cases.interfaces

import com.example.mptwitterclone.feed.domain.models.Tweet

interface GetTimeline {
    suspend fun invoke(): Result<List<Tweet>>
}
