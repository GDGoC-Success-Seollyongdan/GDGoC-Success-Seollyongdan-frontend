package com.example.seollyongdan_frontend.app

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RegionInterceptor @Inject constructor(
    private val apiKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", apiKey) // 헤더에 API 키 추가
            .build()
        return chain.proceed(request)
    }
}
