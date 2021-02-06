package com.example.mptwitterclone

data class Tweet(val user: User, val text: String, val time: Long)

data class User(val userName: String, val firstName: String, val lastName: String)

