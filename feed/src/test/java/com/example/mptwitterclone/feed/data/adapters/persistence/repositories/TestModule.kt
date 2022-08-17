package com.example.mptwitterclone.feed.data.adapters.persistence.repositories

import com.example.mptwitterclone.feed.data.di.modules.FeedRepositoriesModule
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [FeedRepositoriesModule::class]
)
abstract class FakeAnalyticsModule {

    @Singleton
    @Binds
    abstract fun bindTimelineRepository(fakeRepo: FakeTimelineRepositoryImpl): TimelineRepository
}
