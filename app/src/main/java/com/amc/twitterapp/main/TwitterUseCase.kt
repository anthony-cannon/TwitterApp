package com.amc.twitterapp.main

import android.arch.lifecycle.LiveData
import com.amc.twitterapp.api.ApiResponse
import com.amc.twitterapp.api.TwitterService
import com.amc.twitterapp.data.TwitterStatus

/**
 * This class was created by Anthony M Cannon on 27/08/2018.
 */
class TwitterUseCase(private val twitterService: TwitterService) {

    fun getLatestStatuses(): LiveData<ApiResponse<List<TwitterStatus>>> {
        return twitterService.getLatestStatuses(
                871746761387323394,
                "extended",
                1,
                10)
    }
}