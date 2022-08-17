package com.example.mptwitterclone.feed.data.di.modules

import com.example.mptwitterclone.feed.data.adapters.persistence.repositories.TimelineRepository
import com.example.mptwitterclone.feed.data.adapters.persistence.repositories.TimelineRepositoryImpl
import com.example.mptwitterclone.feed.data.adapters.persistence.repositories.local.TimelineRepositoryLocal
import com.example.mptwitterclone.feed.data.adapters.persistence.repositories.remote.TimelineRepositoryRemote
import com.example.mptwitterclone.feed.data.di.qualifiers.LocalTimelineRepository
import com.example.mptwitterclone.feed.data.di.qualifiers.RemoteTimelineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FeedRepositoriesModule {

    @Binds
    abstract fun bindTimelineRepository(repository: TimelineRepositoryImpl): TimelineRepository

    @Binds
    @RemoteTimelineRepository
    abstract fun bindRemoteTimelineRepository(repository: TimelineRepositoryRemote): TimelineRepository

    @Binds
    @LocalTimelineRepository
    abstract fun bindLocalTimelineRepository(repository: TimelineRepositoryLocal): TimelineRepository
}
