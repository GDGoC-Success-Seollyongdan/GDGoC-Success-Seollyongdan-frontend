package com.example.seollyongdan_frontend.app.di

import com.example.seollyongdan_frontend.data.repositoryimpl.AuthRepositoryImpl
import com.example.seollyongdan_frontend.data.repositoryimpl.CommunityRepositoryImpl
import com.example.seollyongdan_frontend.data.repositoryimpl.ExampleRepositoryImpl
import com.example.seollyongdan_frontend.data.repositoryimpl.HomeRepositoryImpl
import com.example.seollyongdan_frontend.data.repositoryimpl.RegionRepositoryImpl
import com.example.seollyongdan_frontend.data.repositoryimpl.SearchRepositoryImpl
import com.example.seollyongdan_frontend.data.repositoryimpl.UserRepositoryImpl
import com.example.seollyongdan_frontend.domain.repository.AuthRepository
import com.example.seollyongdan_frontend.domain.repository.CommunityRepository
import com.example.seollyongdan_frontend.domain.repository.ExampleRepository
import com.example.seollyongdan_frontend.domain.repository.HomeRepository
import com.example.seollyongdan_frontend.domain.repository.RegionRepository
import com.example.seollyongdan_frontend.domain.repository.SearchRepository
import com.example.seollyongdan_frontend.domain.repository.UserRepository
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
    abstract fun bindRegionRepository(
        regionRepositoryImpl: RegionRepositoryImpl
    ) : RegionRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ) : AuthRepository

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ) : HomeRepository

    @Binds
    @Singleton
    abstract fun bindCommunityRepository(
        communityRepositoryImpl: CommunityRepositoryImpl
    ) : CommunityRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ) : UserRepository


    @Binds
    @Singleton
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ) : SearchRepository



    @Binds
    @Singleton
    abstract fun bindExampleRepository(exampleRepositoryImpl: ExampleRepositoryImpl): ExampleRepository
}