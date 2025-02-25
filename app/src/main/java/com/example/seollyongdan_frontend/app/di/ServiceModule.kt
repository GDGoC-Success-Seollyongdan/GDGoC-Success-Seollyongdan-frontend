package com.example.seollyongdan_frontend.app.di

import com.example.seollyongdan_frontend.data.service.AuthApiService
import com.example.seollyongdan_frontend.data.service.ExampleApiService
import com.example.seollyongdan_frontend.data.service.RegionApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun bindRegionApiService(
        @SeollyongdanRetrofit retrofit: Retrofit) : RegionApiService = retrofit.create(RegionApiService::class.java)

    @Provides
    @Singleton
    fun binSignUpApiService(
        @SeollyongdanRetrofit retrofit: Retrofit
    ) : AuthApiService = retrofit.create(AuthApiService::class.java)


    @Provides
    @Singleton
    fun provideExampleService(
        @SeollyongdanRetrofit retrofit: Retrofit
    ): ExampleApiService = retrofit.create(ExampleApiService::class.java)
}