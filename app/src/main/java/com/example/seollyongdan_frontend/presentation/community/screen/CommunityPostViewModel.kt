package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommunityPostViewModel @Inject constructor() : ViewModel(){
    val communityPostList = listOf(

        CommunityPostEntity(
            id = 2,
            userName = "김눈송",
            userDistrict = "용산구 청파동1가",
            postDistrict = "용산구 청파동1가",
            isResident = true,
            title = "공덕동 맛집 추천드려요",
            content = "OOO 고깃집 맛있어요!",
            postTime = 2,
            like = 3,
            view = 38,
            comment =  3
        ),

        CommunityPostEntity(
            id = 3,
            userName = "이눈송",
            userDistrict = "용산구 청파동2가",
            postDistrict = "용산구 청파동1가",
            isResident = false,
            title = "공덕동 맛집 추천드려요",
            content = "OOO 학식 맛있어요!",
            postTime = 2,
            like = 10,
            view = 38,
            comment = 4
        ),

        CommunityPostEntity(
            id = 4,
            userName = "박눈송",
            userDistrict = "용산구",
            postDistrict = "용산구 청파동1가",
            isResident = true,
            title = "공덕동 맛집 추천드려요",
            content = "OOO 한식집 맛있어요!",
            postTime = 3,
            like = 15,
            view = 78,
            comment = 5
        ),

        CommunityPostEntity(
            id = 5,
            userName = "최눈송",
            userDistrict = "용산구 청파동2가",
            postDistrict = "용산구 청파동2가",
            isResident = true,
            title = "숙대 맛집 추천드려요",
            content = "OOO 분식집 맛있어요!",
            postTime = 5,
            like = 12,
            view = 108,
            comment = 6
        ),

        CommunityPostEntity(
            id = 9,
            userName = "함눈송",
            userDistrict = "용산구 청파동1가",
            postDistrict = "용산구 청파동2가",
            isResident = true,
            title = "숙대 맛집 추천드려요",
            content = "OOO 한식집 맛있어요!",
            postTime = 5,
            like = 9,
            view = 18,
            comment = 3
        )

    )
}