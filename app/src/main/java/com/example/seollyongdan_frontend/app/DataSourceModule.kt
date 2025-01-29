package com.example.seollyongdan_frontend.app

import com.example.seollyongdan_frontend.data.datasource.ExampleDataSource
import com.example.seollyongdan_frontend.data.datasourceimpl.ExampleDataSourceImpl
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
    abstract fun bindExampleDataSource(exampleDataSourceImpl: ExampleDataSourceImpl): ExampleDataSource
}