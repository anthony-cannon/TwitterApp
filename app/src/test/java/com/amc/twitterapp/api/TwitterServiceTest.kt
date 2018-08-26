package com.amc.twitterapp.api

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.amc.twitterapp.data.TwitterStatus
import com.amc.twitterapp.util.TestUtil
import com.google.gson.reflect.TypeToken
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
    private lateinit var service: TwitterService

    @Before
    fun initMocks() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun twitterService_CorrectResponse() {
        `when`(service.getLatestStatuses()).thenReturn(getLatestStatusesResponse())

        val statusList = service.getLatestStatuses().value

        verify(service).getLatestStatuses()

        assertEquals(statusList!!.size, 10)

        val status = statusList[0]

        assertEquals(status.createdAt, "Mon Aug 20 15:51:15 +0000 2018")
        assertEquals(status.id, 1031569358391324673)
        assertEquals(status.truncated, false)
        assertEquals(status.displayTextRange!![0], 0)
    }

    private fun getLatestStatusesResponse(): LiveData<List<TwitterStatus>> {
        val type = object : TypeToken<List<TwitterStatus>>() {}.type
        val response = TestUtil.getJsonObject<List<TwitterStatus>>("statuses.json", type)

        return MutableLiveData<List<TwitterStatus>>().apply { value = response }
    }
}