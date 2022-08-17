package com.example.mptwitterclone.feed.domain.di.modules

import com.example.mptwitterclone.feed.domain.use_cases.GetTimelineImpl
import com.example.mptwitterclone.feed.domain.use_cases.interfaces.GetTimeline
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FeedUseCasesModule {

    @Binds
    abstract fun bindGetTimelineUseCase(useCase: GetTimelineImpl): GetTimeline
}
