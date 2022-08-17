package com.example.mptwitterclone.feed.data.adapters.persistence.repositories

import com.example.mptwitterclone.common.network.INetworkManager
import com.example.mptwitterclone.feed.data.di.qualifiers.LocalTimelineRepository
import com.example.mptwitterclone.feed.data.di.qualifiers.RemoteTimelineRepository
import com.example.mptwitterclone.feed.domain.models.Tweet
import javax.inject.Inject


class TimelineRepositoryImpl @Inject constructor(
    private val networkManager: INetworkManager,
    @LocalTimelineRepository
    private val localRepository: TimelineRepository,
    @RemoteTimelineRepository
    private val remoteRepository: TimelineRepository
) : TimelineRepository {
    override suspend fun invoke(): Result<List<Tweet>> {
        return if (networkManager.isNetworkConnected()) return remoteRepository.invoke()
        else localRepository.invoke()
    }
}
