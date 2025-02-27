package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.CommunityDataSource
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto
import com.example.seollyongdan_frontend.domain.repository.CommunityRepository
import javax.inject.Inject

class CommunityRepositoryImpl @Inject constructor(
    private val communityDataSource: CommunityDataSource
) : CommunityRepository {

    override suspend fun getAllPosts(): Result<List<ResponseCommunityPostDto>> {
        return runCatching {
            val response = communityDataSource.getAllPosts()
            val result = response.result ?: throw Exception("Result is Null")

            result.map { post ->
                ResponseCommunityPostDto(
                    postId = post.postId,
                    postNickname = post.postNickname,
                    userDistrick = post.userDistrick,
                    postDistrict = post.postDistrict,
                    isResident = post.isResident,
                    title = post.title,
                    content = post.content,
                    postTime = post.postTime,
                    likeCount = post.likeCount,
                    viewCount = post.viewCount,
                    commentCount = post.commentCount
                )
            }
        }
    }
}
