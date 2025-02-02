package com.example.seollyongdan_frontend.app.di

import com.example.seollyongdan_frontend.data.service.ExampleApiService
import com.example.seollyongdan_frontend.data.service.RegionApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideRegionApiService(retrofit: Retrofit): RegionApiService {
        return retrofit.create(RegionApiService::class.java)
    }
}