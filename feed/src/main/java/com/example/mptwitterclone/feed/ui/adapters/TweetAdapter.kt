package com.example.mptwitterclone.feed.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mptwitterclone.feed.R
import com.example.mptwitterclone.feed.databinding.TweetItemBinding
import com.example.mptwitterclone.feed.domain.models.Tweet

class TweetAdapter(
    private val tweetDetails: ((tweet: Tweet) -> Unit)? = null,
    private val seeCommentsListener: ((tweet: Tweet) -> Unit)? = null,
    private val retweetListener: ((tweet: Tweet) -> Unit)? = null,
    private val loveTweetListener: ((tweet: Tweet) -> Unit)? = null,
    private val shareListener: ((tweet: Tweet) -> Unit)? = null,
    private val moreOptions: ((tweet: Tweet) -> Unit)? = null
) : RecyclerView.Adapter<TweetViewHolder>() {

    private val timeline = mutableListOf<Tweet>()

    fun setData(items: List<Tweet>?) {
        items?.let {
            val oldPosition = this.timeline.size
            timeline.addAll(items)
            notifyItemRangeChanged(oldPosition, timeline.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TweetItemBinding>(
            layoutInflater,
            R.layout.tweet_item,
            parent,
            false
        )
        return TweetViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return timeline.size
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val tweet = timeline[position]
        holder.bind(
            tweet,
            tweetDetails,
            seeCommentsListener,
            retweetListener,
            loveTweetListener,
            shareListener,
            moreOptions
        )
    }

}
