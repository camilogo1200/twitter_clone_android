package com.example.mptwitterclone.common.network

interface INetworkManager {
    suspend fun isNetworkConnected(): Boolean
}
