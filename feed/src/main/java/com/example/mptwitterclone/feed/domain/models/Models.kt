package com.example.mptwitterclone.feed.domain.models

data class Tweet(val id: String, val user: User, val text: String, val time: Long)

data class User(val userName: String, val firstName: String, val lastName: String)
