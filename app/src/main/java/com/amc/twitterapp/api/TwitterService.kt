package com.amc.twitterapp.api

import android.arch.lifecycle.LiveData
import com.amc.twitterapp.data.TwitterStatus
import retrofit2.http.GET

/**
 * This class was created by Anthony M Cannon on 26/08/2018.
 */
interface TwitterService {

    @GET("lists/statuses.json?list_id=871746761387323394&tweet_mode=extended&include_entities=1&count=10")
    fun getLatestStatuses(): LiveData<List<TwitterStatus>>
}