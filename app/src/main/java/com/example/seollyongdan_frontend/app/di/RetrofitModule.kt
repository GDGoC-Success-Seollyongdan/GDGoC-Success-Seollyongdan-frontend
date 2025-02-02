package com.example.seollyongdan_frontend.app.di

import com.example.seollyongdan_frontend.BuildConfig
import com.example.seollyongdan_frontend.app.RegionInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val REGION_BASE_URL = "api.odcloud.kr/api"

    @Provides
    @Singleton
    fun provideApiKey(): String {
        return BuildConfig.REGION_API_KEY // Gradle에서 불러온 API 키
    }

    @Provides
    @Singleton
    fun provideRegionInterceptor(apiKey: String): RegionInterceptor {
        return RegionInterceptor(apiKey)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(regionInterceptor: RegionInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(regionInterceptor) // 모든 요청에 API 키 자동 추가
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}










    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()


    @Singleton
    @Provides
    @SeollyongdanRetrofit
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .client(okHttpClient)
        .baseUrl("")
        .build()
}