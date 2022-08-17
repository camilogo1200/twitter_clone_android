package com.example.mptwitterclone.feed.data.adapters.network.dto

import com.example.mptwitterclone.feed.domain.models.User
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(val userName: String, val firstName: String, val lastName: String) {
    fun toModel(): User {
        return User(
            userName,
            firstName,
            lastName
        )
    }

    companion object {
        fun fromModel(user: User): UserDto {
            return UserDto(
                user.userName,
                user.firstName,
                user.lastName
            )
        }
    }
}
