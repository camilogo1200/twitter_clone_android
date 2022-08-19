package com.example.mptwitterclone.tweetcreation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mptwitterclone.tweetcreation.R
import com.example.mptwitterclone.tweetcreation.databinding.FragmentTweetCreationBinding

class TweetCreationFragment : Fragment() {

    private lateinit var binding: FragmentTweetCreationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_tweet_creation, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = TweetCreationFragment()
    }
}
