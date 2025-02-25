package com.example.seollyongdan_frontend.app.di

import com.example.seollyongdan_frontend.data.datasource.ExampleDataSource
import com.example.seollyongdan_frontend.data.datasource.RegionDataSource
import com.example.seollyongdan_frontend.data.datasource.AuthDataSource
import com.example.seollyongdan_frontend.data.datasourceimpl.ExampleDataSourceImpl
import com.example.seollyongdan_frontend.data.datasourceimpl.RegionDataSourceImpl
import com.example.seollyongdan_frontend.data.datasourceimpl.AuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteRegionDataSource(
        regionDataSourceImpl: RegionDataSourceImpl
    ) : RegionDataSource

    @Binds
    @Singleton
    abstract fun bindAuthDataSource(
        authDataSourceImpl: AuthDataSourceImpl
    ) : AuthDataSource


    @Binds
    @Singleton
    abstract fun bindExampleDataSource(exampleDataSourceImpl: ExampleDataSourceImpl): ExampleDataSource
}