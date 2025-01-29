package com.example.seollyongdan_frontend.app

import com.example.seollyongdan_frontend.data.repositoryimpl.ExampleRepositoryImpl
import com.example.seollyongdan_frontend.domain.repository.ExampleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindExampleRepository(exampleRepositoryImpl: ExampleRepositoryImpl): ExampleRepository
}