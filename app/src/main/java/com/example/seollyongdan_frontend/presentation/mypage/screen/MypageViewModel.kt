package com.example.seollyongdan_frontend.presentation.mypage.screen

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MypageViewModel @Inject constructor(
    private val preferences: SharedPreferences
) : ViewModel() {

    fun removeToken(){
        viewModelScope.launch {
            preferences.edit().remove("USER_TOKEN").apply()
        }
    }
}
