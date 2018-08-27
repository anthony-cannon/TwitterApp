package com.amc.twitterapp.api

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.amc.twitterapp.util.TestUtil.getLatestStatusesResponse
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * This class was created by Anthony M Cannon on 26/08/2018.
 */
class TwitterServiceTest {

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var twitterService: TwitterService

    @Before
    fun initMocks() {
        MockitoAnnotations.initMocks(this)

        `when`(twitterService.getLatestStatuses(
                871746761387323394,
                "extended",
                1,
                10)).thenReturn(getLatestStatusesResponse())
    }

    @Test
    fun twitterService_CorrectResponse() {

        val response = twitterService.getLatestStatuses(
                871746761387323394,
                "extended",
                1,
                10).value

        val statusList = (response as ApiSuccessResponse).body

        verify(twitterService).getLatestStatuses(
                871746761387323394,
                "extended",
                1,
                10)

        assertEquals(statusList.size, 10)

        val status = statusList[0]

        assertEquals(status.createdAt, "Mon Aug 20 15:51:15 +0000 2018")
        assertEquals(status.id, 1031569358391324673)
        assertEquals(status.truncated, false)
        assertEquals(status.displayTextRange!![0], 0)
    }
}