package com.example.mptwitterclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TweetAdapter(val timeline: Array<Tweet>) :
    RecyclerView.Adapter<TweetAdapter.TweetViewHolder>() {

    class TweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tweetTextView: TextView = itemView.findViewById(R.id.tweet_text)
        private val timeTextView: TextView = itemView.findViewById(R.id.time_text)
        private val nameTextView: TextView = itemView.findViewById(R.id.name_text)

        fun bind(tweet: Tweet) {
            tweetTextView.text = tweet.text
            //TODO: format the time nicely as seconds/minutes/hours/days in the past
            timeTextView.text = tweet.time.toString()

            //TODO: update to display the first, last and username in different views
            nameTextView.text = tweet.user.userName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tweet_item, parent, false)

        return TweetViewHolder(view)
    }

    override fun getItemCount(): Int {
        return timeline.size
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        holder.bind(timeline[position])
    }
}