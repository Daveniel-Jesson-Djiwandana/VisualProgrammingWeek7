package com.davenieljessondjiwandana.assignmentweek7.soal1.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("Authorization", "Bearer $apiKey")
            .header("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}