package com.example.mptwitterclone.feed.data.adapters.network.dto

import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class TimelineResponse(
    val info: InformationDto,
    val results: List<TweetDto>
)

@Serializable
data class InformationDto(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
