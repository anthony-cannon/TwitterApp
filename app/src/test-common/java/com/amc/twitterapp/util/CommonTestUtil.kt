package com.amc.twitterapp.util

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors

object CommonTestUtil {
    fun <T> getValue(liveData: LiveData<T>): T {
        val data = arrayOfNulls<Any>(1)
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data[0] = o
                latch.countDown()
                liveData.removeObserver(this)
            }
        }
        liveData.observeForever(observer)
        latch.await(2, TimeUnit.SECONDS)

        @Suppress("UNCHECKED_CAST")
        return data[0] as T
    }

    fun <T> getJsonObject(fileName: String, typeOfT: Type): T {
        val bufferedReader = BufferedReader(InputStreamReader(javaClass.classLoader!!
                .getResourceAsStream("api-response/$fileName"), Charsets.UTF_8))

        val json = bufferedReader.lines()
                .parallel()
                .collect(Collectors.joining())
        return Gson().fromJson<T>(json, typeOfT)
    }
}
