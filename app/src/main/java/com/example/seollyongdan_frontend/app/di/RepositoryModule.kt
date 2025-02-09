package com.example.seollyongdan_frontend.app.di

import com.example.seollyongdan_frontend.data.datasource.RegionDataSource
import com.example.seollyongdan_frontend.data.repositoryimpl.ExampleRepositoryImpl
import com.example.seollyongdan_frontend.data.repositoryimpl.RegionRepositoryImpl
import com.example.seollyongdan_frontend.domain.repository.ExampleRepository
import com.example.seollyongdan_frontend.domain.repository.RegionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRegionRepository(
        regionRepositoryImpl: RegionRepositoryImpl
    ) : RegionRepository

    @Binds
    @Singleton
    abstract fun bindExampleRepository(exampleRepositoryImpl: ExampleRepositoryImpl): ExampleRepository
}