package com.example.seollyongdan_frontend.presentation.community.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CommunityDetailViewModel @Inject constructor() : ViewModel() {
    private val _communityDetailList = MutableStateFlow(

        CommunityPostDetailEntity(
            CommunityPostEntity(
                id = 1,
                userName = "눈송이",
                userDistrict = "용산구 청파동1가",
                postDistrict = "용산구 청파동1가",
                isResident = true,
                title = "숙대 짱인듯",
                content = "암튼 짱",
                postTime = 2,
                like = 10,
                view = 150,
                comment = 3

            ),
            comments = listOf(
                CommentEntity(
                    id = 1,
                    userName = "박눈송",
                    userDistrict = "용산구 청파동2가",
                    isResident = true,
                    content = "맞아요!",
                    postTime = 1
                ),
                CommentEntity(
                    id = 2,
                    userName = "최눈송",
                    userDistrict = "송파구 땡땡동",
                    isResident = true,
                    content = "숙대 대박",
                    postTime = 3
                )
            )
        )
    )
    val communityDetailList: StateFlow<CommunityPostDetailEntity> = _communityDetailList

    fun addComment(content: String) {
        val newComment = CommentEntity(
            id = (_communityDetailList.value.comments.maxOfOrNull { it.id } ?: 0) + 1,
            userName = "새로운 유저",
            userDistrict = "알 수 없음",
            isResident = false,
            content = content,
            postTime = 0
        )

        _communityDetailList.value = _communityDetailList.value.copy(
            comments = _communityDetailList.value.comments + newComment
        )
    }
}


