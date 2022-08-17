package com.example.mptwitterclone.feed.domain.use_cases

import com.example.mptwitterclone.feed.data.adapters.persistence.repositories.TimelineRepository
import com.example.mptwitterclone.feed.domain.models.Tweet
import com.example.mptwitterclone.feed.domain.use_cases.interfaces.GetTimeline
import javax.inject.Inject

class GetTimelineImpl @Inject constructor(
    private val timelineRepository: TimelineRepository
) : GetTimeline {
    override suspend fun invoke(): Result<List<Tweet>> {
        val result: Result<List<Tweet>> = timelineRepository.invoke()
        return result
    }
}
