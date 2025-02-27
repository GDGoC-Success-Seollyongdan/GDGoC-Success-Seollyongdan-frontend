package com.example.seollyongdan_frontend.presentation.main.screen

data class UserEntity (
    val userId : Int,

    val district : String, //용산구 청파로1가
    val isResident : Boolean, //거주자 인증 되어 있는지
)