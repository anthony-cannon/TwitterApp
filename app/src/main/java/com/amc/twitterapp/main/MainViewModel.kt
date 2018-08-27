package com.amc.twitterapp.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.amc.twitterapp.api.ApiResponse
import com.amc.twitterapp.api.RequestInterceptor
import com.amc.twitterapp.api.TwitterService
import com.amc.twitterapp.data.TwitterStatus
import com.amc.twitterapp.util.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class was created by Anthony M Cannon on 26/08/2018.
 */
open class MainViewModel : ViewModel() {

    companion object {
        private const val BASE_URL = "https://api.twitter.com/1.1/"
    }

    private val twitter: TwitterUseCase
    private var list: LiveData<ApiResponse<List<TwitterStatus>>>

    init {
        val retrofit = getRetrofitInstance()
        val service = retrofit.create(TwitterService::class.java)
        twitter = TwitterUseCase(service)

        list = twitter.getLatestStatuses()
    }

    open fun getList(): LiveData<ApiResponse<List<TwitterStatus>>> = list

    private fun getRetrofitInstance(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().apply {
            addInterceptor(RequestInterceptor())
            addInterceptor(logging)
        }.build()

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
    }
}