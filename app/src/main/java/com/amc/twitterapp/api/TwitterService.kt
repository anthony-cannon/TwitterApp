package com.amc.twitterapp.api

import android.arch.lifecycle.LiveData
import com.amc.twitterapp.data.TwitterStatus
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This class was created by Anthony M Cannon on 26/08/2018.
 */
interface TwitterService {

    @GET("lists/statuses.json")
    fun getLatestStatuses(@Query("list_id") id: Long,
                          @Query("tweet_mode") tweetMode: String,
                          @Query("include_entities") includeEntities: Int,
                          @Query("count") count: Int): LiveData<ApiResponse<List<TwitterStatus>>>
}