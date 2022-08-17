package com.example.mptwitterclone.feed.ui.view_states

import com.example.mptwitterclone.feed.domain.models.Tweet

sealed interface FeedViewState {
    data class TimelineFetched(val tweets: List<Tweet>?) : FeedViewState
    object FailedTimelineFetch : FeedViewState
}
