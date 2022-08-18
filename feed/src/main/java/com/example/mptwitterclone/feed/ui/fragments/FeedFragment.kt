package com.example.mptwitterclone.feed.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mptwitterclone.common.showSnackBarError
import com.example.mptwitterclone.feed.Datasource
import com.example.mptwitterclone.feed.R
import com.example.mptwitterclone.feed.databinding.FragmentFeedBinding
import com.example.mptwitterclone.feed.domain.models.Tweet
import com.example.mptwitterclone.feed.ui.adapters.TweetAdapter
import com.example.mptwitterclone.feed.ui.view_models.FeedViewModel
import com.example.mptwitterclone.feed.ui.view_states.FeedViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private val viewmodel: FeedViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val timeline = Datasource(requireContext()).getTimeline()
        bindObservers()
        bindAdapter()
        bindListeners()
        viewmodel.initView()
    }

    private fun bindListeners() {
        binding.newTweet.setOnClickListener {
            navigateToTweetCreation()
        }
    }

    private fun navigateToTweetCreation() {

        val navController = findNavController()
        //navController.navigate()
    }

    private fun bindAdapter() {
        binding.recyclerView.adapter = TweetAdapter(
            ::seeTweetDetails,
            ::seeComments,
            ::retweet,
            ::loveTweet,
            ::share,
            ::moreOptions
        )
    }


    private fun bindObservers() {
        viewmodel.viewState.observe(viewLifecycleOwner, ::handleViewState)
    }

    private fun handleViewState(feedViewState: FeedViewState?) {
        feedViewState?.let { viewState ->
            when (viewState) {
                is FeedViewState.TimelineFetched -> handleTimeLineFetched(viewState.tweets)
                is FeedViewState.FailedTimelineFetch -> handleFailedFetchedTimeline()
                else -> handleGenericError()
            }
        }
    }


    private fun handleTimeLineFetched(tweets: List<Tweet>?) {
        val adapter = binding.recyclerView.adapter as TweetAdapter
        adapter.setData(tweets)
    }

    private fun handleFailedFetchedTimeline() {
        showSnackBarError(
            requireContext(),
            binding.root,
            "Please check your internet connection!",
            R.color.red
        )
    }

    private fun handleGenericError() {

    }

    private fun moreOptions(tweet: Tweet) {
        showSnackBarError(requireContext(), binding.root, "More Options menu!", R.color.teal)
    }

    private fun share(tweet: Tweet) {
        showSnackBarError(requireContext(), binding.root, "Share tweet!", R.color.lime)
    }

    private fun retweet(tweet: Tweet) {
        showSnackBarError(requireContext(), binding.root, "Re-tweet!", R.color.pink)
    }

    private fun loveTweet(tweet: Tweet) {
        showSnackBarError(requireContext(), binding.root, "Love It!", R.color.cyan)
    }

    private fun seeComments(tweet: Tweet) {
        showSnackBarError(requireContext(), binding.root, "Searching comments!", R.color.purple)
    }

    private fun seeTweetDetails(tweet: Tweet) {
        showSnackBarError(requireContext(), binding.root, "Tweet details!", R.color.green)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeedFragment()
    }
}
