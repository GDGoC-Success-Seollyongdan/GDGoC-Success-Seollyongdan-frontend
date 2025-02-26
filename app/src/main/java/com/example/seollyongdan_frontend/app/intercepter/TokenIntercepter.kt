package com.example.seollyongdan_frontend.app.intercepter

import android.content.SharedPreferences
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val preferences: SharedPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val prefs = preferences
        val token = prefs.getString("USER_TOKEN", null)

        Log.d("TokenInterceptor", "Retrieved Token: $token") //불러온 토큰 확인

        // 토큰이 있을 경우 Authorization 헤더에 포함
        val request = chain.request().newBuilder().apply {
            token?.let {
                addHeader("Authorization", "Bearer $it")
            }
        }.build()

        return chain.proceed(request)
    }
}
