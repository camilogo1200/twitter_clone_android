package com.example.mptwitterclone.feed.data.di.qualifiers

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class LocalTimelineRepository


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class RemoteTimelineRepository
