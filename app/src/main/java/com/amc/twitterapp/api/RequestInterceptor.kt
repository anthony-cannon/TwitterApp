package com.amc.twitterapp.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * This class was created by Anthony M Cannon on 26/08/2018.
 */
class RequestInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        /* Normally the bearer token would be dynamic and just the Consumer API keys would be stored.
         * This would enable me to issue an application-only request to Twitter to obtain the bearer
         * token. Either on my own or through the Twitter API.
         */

        val request = original.newBuilder()
                .header("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAF7w0wAAAAAAb6kdTQSU%2F5EmGAMD917iN7rZuVE%3D9ssQYqmHSgDTUgLDOW3k155qYVOxrGUaDSeOrW3IqvHeSoRYiu")
                .header("Content-Type", "application/json")
                .method(original.method(), original.body())
                .build()

        return chain.proceed(request)
    }
}