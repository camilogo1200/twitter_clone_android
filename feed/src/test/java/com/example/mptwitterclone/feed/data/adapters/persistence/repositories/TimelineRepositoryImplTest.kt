package com.example.mptwitterclone.feed.data.adapters.persistence.repositories

import com.example.mptwitterclone.common.network.NetworkManager
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
internal class TimelineRepositoryImplTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `should invoke local repository due to network connection not available`() = runBlocking {
        val networkManager = NetworkManager()
        //given
        coEvery { networkManager.isNetworkConnected() } returns false
        //when
        //then
        coVerify(exactly = 1) { }

    }

    @Test
    fun `should invoke remote repository due to network connection available`() = runBlocking {
        //given
        //when
        //then
    }
}
