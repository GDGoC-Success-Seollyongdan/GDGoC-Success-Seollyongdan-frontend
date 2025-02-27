package com.example.seollyongdan_frontend.presentation.community.screen

data class CommunityPostDetailEntity(
    val post : CommunityPostEntity,
    val comments: List<CommentEntity> // 댓글 리스트
) {
}

data class CommentEntity(
    val id: Int,
    val userName: String,
    val userDistrict: String,
    val isResident: Boolean,
    val content: String,
    val postTime: Int
)

