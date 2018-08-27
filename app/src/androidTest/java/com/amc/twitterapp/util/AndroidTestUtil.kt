package com.amc.twitterapp.util

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.amc.twitterapp.api.ApiResponse
import com.amc.twitterapp.api.ApiSuccessResponse
import com.amc.twitterapp.data.TwitterStatus
import com.google.gson.reflect.TypeToken


/**
 * This class was created by Anthony M Cannon on 27/08/2018.
 */
object AndroidTestUtil {

    fun postLatestStatusesResponse(): LiveData<ApiResponse<List<TwitterStatus>>> {
        val type = object : TypeToken<List<TwitterStatus>>() {}.type
        val response = CommonTestUtil.getJsonObject<List<TwitterStatus>>("statuses.json", type)

        return MutableLiveData<ApiResponse<List<TwitterStatus>>>().apply {
            postValue(ApiSuccessResponse<List<TwitterStatus>>(response, null))
        }
    }
}