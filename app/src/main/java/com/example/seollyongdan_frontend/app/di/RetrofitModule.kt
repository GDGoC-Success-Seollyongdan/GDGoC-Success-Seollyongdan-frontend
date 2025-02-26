package com.example.seollyongdan_frontend.app.di

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
import com.example.seollyongdan_frontend.app.RegionInterceptor
import com.example.seollyongdan_frontend.BuildConfig
import com.example.seollyongdan_frontend.app.intercepter.TokenInterceptor
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val REGION_BASE_URL = "https://api.odcloud.kr/api/"

    @Provides
    @Singleton
    fun provideApiKey(): String {
        return BuildConfig.REGION_API_KEY
    }

    @Provides
    @Singleton
    fun provideRegionInterceptor(apiKey: String): RegionInterceptor {
        return RegionInterceptor(apiKey)
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    // 지역 API용 OkHttpClient
    @Provides
    @Singleton
    @Named("regionClient")
    fun provideRegionOkHttpClient(
        regionInterceptor: RegionInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(regionInterceptor) // 지역 API 키 추가
            .addInterceptor(loggingInterceptor) // 로그 추가
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    // 애플리케이션 API용 OkHttpClient
    @Provides
    @Singleton
    @Named("appClient")
    fun provideAppOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        tokenInterceptor: TokenInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // 로그 추가
            .addInterceptor(tokenInterceptor) // 토큰 인터셉터 추가
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @RegionRetrofit
    @Provides
    @Singleton
    fun provideRegionRetrofit(@Named("regionClient") okHttpClient: OkHttpClient): Retrofit {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(REGION_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @SeollyongdanRetrofit
    @Provides
    @Singleton
    fun provideSeollyongdanRetrofit(@Named("appClient") okHttpClient: OkHttpClient): Retrofit {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SEOLLYONGDAN_BASE_URL) // 실제 API URL로 변경 필요
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}