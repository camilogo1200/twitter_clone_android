package com.example.mptwitterclone.feed.data.adapters.network.dto

import com.example.mptwitterclone.feed.domain.models.Tweet
import kotlinx.serialization.Serializable

@Serializable
data class TweetDto(
    val id: String,
    val user: UserDto,
    val text: String,
    val time: Long,
    val image: String? = null,
    val video: String? = null
) {
    fun fromModel(tweet: Tweet): TweetDto {
        return TweetDto(
            tweet.id,
            UserDto.fromModel(tweet.user),
            tweet.text,
            tweet.time,
            tweet.image,
            tweet.video
        )
    }

    fun toModel(): Tweet {
        return Tweet(
            id,
            user.toModel(),
            text,
            time,
            image,
            video
        )
    }
}
