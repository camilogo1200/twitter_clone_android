package com.example.mptwitterclone.feed.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mptwitterclone.feed.domain.use_cases.interfaces.GetTimeline
import com.example.mptwitterclone.feed.ui.view_states.FeedViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getTimelineUC: GetTimeline
) : ViewModel() {

    private val _viewState = MutableLiveData<FeedViewState>()
    val viewState: LiveData<FeedViewState> = _viewState

    private fun setViewState(newState: FeedViewState) {
        _viewState.value = newState
    }

    fun initView() {
        viewModelScope.launch {
            val tweets = getTimelineUC.invoke()
            if (tweets.isSuccess) setViewState(FeedViewState.TimelineFetched(tweets.getOrNull()))
            else setViewState(FeedViewState.FailedTimelineFetch)
        }
    }

}
