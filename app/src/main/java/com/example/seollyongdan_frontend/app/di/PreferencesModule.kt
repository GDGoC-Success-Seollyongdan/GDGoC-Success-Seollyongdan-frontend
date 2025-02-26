package com.example.seollyongdan_frontend.app.di

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.seollyongdan_frontend.app.intercepter.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        Log.d("PreferencesModule", "SharedPreferences instance: $prefs")
        return prefs    }

    @Provides
    @Singleton
    fun provideTokenInterceptor(preferences: SharedPreferences): TokenInterceptor {
        return TokenInterceptor(preferences)
    }
}
