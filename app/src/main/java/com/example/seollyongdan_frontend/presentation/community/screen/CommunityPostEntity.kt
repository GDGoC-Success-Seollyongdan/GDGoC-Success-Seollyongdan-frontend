package com.example.seollyongdan_frontend.presentation.community.screen

data class CommunityPostEntity (
    val id : Long,
    val userName : String,
    val userDistrict : String,
    val postDistrict : String,
    val isResident : Boolean,
    val title : String,
    val content : String,
    val postTime : Int,
    val like : Int,
    val view : Int,
    val comment : Int
)

