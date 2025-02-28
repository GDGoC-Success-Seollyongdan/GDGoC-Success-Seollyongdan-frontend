package com.example.seollyongdan_frontend.app.di

import com.example.seollyongdan_frontend.data.datasource.ExampleDataSource
import com.example.seollyongdan_frontend.data.datasource.RegionDataSource
import com.example.seollyongdan_frontend.data.datasource.AuthDataSource
import com.example.seollyongdan_frontend.data.datasource.CommunityDataSource
import com.example.seollyongdan_frontend.data.datasource.HomeDataSource
import com.example.seollyongdan_frontend.data.datasource.SearchDataSource
import com.example.seollyongdan_frontend.data.datasource.UserDataSource
import com.example.seollyongdan_frontend.data.datasourceimpl.ExampleDataSourceImpl
import com.example.seollyongdan_frontend.data.datasourceimpl.RegionDataSourceImpl
import com.example.seollyongdan_frontend.data.datasourceimpl.AuthDataSourceImpl
import com.example.seollyongdan_frontend.data.datasourceimpl.CommunityDataSourceImpl
import com.example.seollyongdan_frontend.data.datasourceimpl.HomeDataSourceImpl
import com.example.seollyongdan_frontend.data.datasourceimpl.SearchDataSourceImpl
import com.example.seollyongdan_frontend.data.datasourceimpl.UserDataSourceImpl
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
    abstract fun bindHomeDataSource(
        homeDataSourceImpl: HomeDataSourceImpl
    ) : HomeDataSource

    @Binds
    @Singleton
    abstract fun bindCommunityDataSource(
        communityDataSourceImpl: CommunityDataSourceImpl
    ) : CommunityDataSource

    @Binds
    @Singleton
    abstract fun bindUserDataSource(
        userDataSourceImpl: UserDataSourceImpl
    ) : UserDataSource


    @Binds
    @Singleton
    abstract fun bindSearchDataSource(
        searchDataSourceImpl: SearchDataSourceImpl
    ) : SearchDataSource


    @Binds
    @Singleton
    abstract fun bindExampleDataSource(exampleDataSourceImpl: ExampleDataSourceImpl): ExampleDataSource
}