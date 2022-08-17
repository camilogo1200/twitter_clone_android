package com.example.mptwitterclone.feed

import android.content.Context
import com.example.mptwitterclone.feed.domain.models.Tweet

/**
 * TODO: Update this to pull from a service abstraction.
 * - This could be a local persistence, or a webservice, or some combination
 * - The timeline should be constructed based on the tweets that the current user follows, not all users.
 */
class Datasource(val context: Context) {
    fun getTimeline(): Array<Tweet> {
        return arrayOf(
            /* Tweet(
                 User("joemctweeter", "Joe", "McTweeter"),
                 "This is a good tweet.",
                 System.currentTimeMillis()
             ),
             Tweet(
                 User("joemctweeter", "Joe", "McTweeter"),
                 "This is a good tweet.",
                 System.currentTimeMillis()
             ),
             Tweet(
                 User("joemctweeter", "Joe", "McTweeter"),
                 "This is a good tweet.",
                 System.currentTimeMillis()
             ),
             Tweet(
                 User("joemctweeter", "Joe", "McTweeter"),
                 "This is a good tweet.",
                 System.currentTimeMillis()
             ),
             Tweet(
                 User("joemctweeter", "Joe", "McTweeter"),
                 "This is a good tweet.",
                 System.currentTimeMillis()
             ),
             Tweet(
                 User("joemctweeter", "Joe", "McTweeter"),
                 "This is a good tweet.",
                 System.currentTimeMillis()
             ),
             Tweet(
                 User("joemctweeter", "Joe", "McTweeter"),
                 "This is a good tweet.",
                 System.currentTimeMillis()
             ),
             Tweet(
                 User("joemctweeter", "Joe", "McTweeter"),
                 "This is a good tweet.",
                 System.currentTimeMillis()
             )*/
        )
    }
}
