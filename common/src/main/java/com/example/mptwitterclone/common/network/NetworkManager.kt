package com.example.mptwitterclone.common.network

import javax.inject.Inject

class NetworkManager @Inject constructor() : INetworkManager {
    override suspend fun isNetworkConnected(): Boolean {
        return true //TODO implement properly with lifecycle aware listener and a hot channel (flow) -> scope of project is only "remote"
    }
}
