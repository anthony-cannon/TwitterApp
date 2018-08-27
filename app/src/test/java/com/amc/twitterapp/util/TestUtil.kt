package com.amc.twitterapp.util

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.amc.twitterapp.api.ApiResponse
import com.amc.twitterapp.api.ApiSuccessResponse
import com.amc.twitterapp.data.TwitterStatus
import com.google.gson.reflect.TypeToken

object TestUtil {

    fun getLatestStatusesResponse(): LiveData<ApiResponse<List<TwitterStatus>>> {
        val type = object : TypeToken<List<TwitterStatus>>() {}.type
        val response = CommonTestUtil.getJsonObject<List<TwitterStatus>>("statuses.json", type)

        return MutableLiveData<ApiResponse<List<TwitterStatus>>>().apply {
            value = ApiSuccessResponse<List<TwitterStatus>>(response, null)
        }
    }
}
