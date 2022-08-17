package com.example.mptwitterclone.feed.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.mptwitterclone.common.DateUtils
import com.example.mptwitterclone.feed.R
import com.example.mptwitterclone.feed.databinding.TweetItemBinding
import com.example.mptwitterclone.feed.domain.models.Tweet
import java.util.*

class TweetViewHolder(databinding: TweetItemBinding) : RecyclerView.ViewHolder(databinding.root) {
    val binding: TweetItemBinding = databinding

    fun bind(
        tweet: Tweet,
        tweetDetails: ((tweet: Tweet) -> Unit)? = null,
        seeCommentsListener: ((tweet: Tweet) -> Unit)? = null,
        retweetListener: ((tweet: Tweet) -> Unit)? = null,
        loveTweetListener: ((tweet: Tweet) -> Unit)? = null,
        shareListener: ((tweet: Tweet) -> Unit)? = null,
        moreOptions: ((tweet: Tweet) -> Unit)? = null
    ) {
        bindInfo(tweet)
        bindListeners(
            tweet,
            tweetDetails,
            seeCommentsListener,
            retweetListener,
            loveTweetListener,
            shareListener,
            moreOptions
        )
    }

    private fun bindInfo(tweet: Tweet) {
        binding.tweetText.text = tweet.text
        //TODO: format the time nicely as seconds/minutes/hours/days in the past
        binding.timeText.text = DateUtils.getTweetTimeFormat(tweet.time)
        //TODO: update to display the first, last and username in different views
        binding.profileNameText.text = "${tweet.user.firstName} ${tweet.user.lastName}"
        binding.profileUsernameText.text = tweet.user.userName
        val resource = getImageResource()

        binding.profileImage.setImageResource(resource)
    }

    private fun getImageResource(): Int {
        val rnd = Random().nextInt(10)
        return when (rnd) {
            1 -> R.drawable.avatar12
            2 -> R.drawable.avatar13
            3 -> R.drawable.avatar14
            4 -> R.drawable.avatar15
            5 -> R.drawable.avatar16
            6 -> R.drawable.avatar17
            7 -> R.drawable.avatar18
            8 -> R.drawable.avatar19
            9 -> R.drawable.avatar20
            0 -> R.drawable.avatar21
            else -> R.drawable.profile_image
        }
    }


    private fun bindListeners(
        tweet: Tweet,
        tweetDetails: ((tweet: Tweet) -> Unit)?,
        seeCommentsListener: ((tweet: Tweet) -> Unit)?,
        retweetListener: ((tweet: Tweet) -> Unit)?,
        loveTweetListener: ((tweet: Tweet) -> Unit)?,
        shareListener: ((tweet: Tweet) -> Unit)?,
        moreOptions: ((tweet: Tweet) -> Unit)?
    ) {
        with(binding) {
            tweetText.setOnClickListener { tweetDetails?.invoke(tweet) }
            commentTweetBtn.setOnClickListener { seeCommentsListener?.invoke(tweet) }
            retweetBtn.setOnClickListener { retweetListener?.invoke(tweet) }
            loveTweetBtn.setOnClickListener { loveTweetListener?.invoke(tweet) }
            shareTweetBtn.setOnClickListener { shareListener?.invoke(tweet) }
            imageView.setOnClickListener { moreOptions?.invoke(tweet) }
        }
    }

}
