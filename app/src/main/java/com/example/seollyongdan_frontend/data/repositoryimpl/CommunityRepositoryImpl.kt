package com.example.seollyongdan_frontend.data.repositoryimpl

import com.example.seollyongdan_frontend.data.datasource.CommunityDataSource
import com.example.seollyongdan_frontend.data.dto.request.RequestCommentPostDto
import com.example.seollyongdan_frontend.data.dto.request.RequestCommunityNewPostDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostCommentDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto
import com.example.seollyongdan_frontend.domain.repository.CommunityRepository
import javax.inject.Inject

class CommunityRepositoryImpl @Inject constructor(
    private val communityDataSource: CommunityDataSource
) : CommunityRepository {

    override suspend fun getAllPosts(district : String): Result<List<ResponseCommunityPostDto>> {
        return runCatching {
            val response = communityDataSource.getAllPosts(district)
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

    override suspend fun postNewPost(requestCommunityNewPostDto: RequestCommunityNewPostDto): Result<Boolean> {
        return runCatching {
            communityDataSource.postNewPost(requestCommunityNewPostDto).success
        }
    }


    override suspend fun getPostComment(postId: Int): Result<List<ResponseCommunityPostCommentDto>> {
        return runCatching {
            val response = communityDataSource.getPostComments(postId)
            val result = response.result ?: throw Exception("Result is Null")

            result.map {comment ->
                ResponseCommunityPostCommentDto(
                    commentId = comment.commentId,
                    content = comment.content
                )
            }
        }
    }

    override suspend fun getPostDetail(postId: Int): Result<ResponseCommunityPostDto> {
        return runCatching {
            val response = communityDataSource.getPostDetail(postId)
            val result = response.result ?: throw Exception("Result is Null")

            ResponseCommunityPostDto(
                postId = result.postId,
                postNickname = result.postNickname,
                userDistrick = result.userDistrick,
                postDistrict = result.postDistrict,
                isResident = result.isResident,
                title = result.title,
                content = result.content,
                postTime = result.postTime,
                likeCount = result.likeCount,
                viewCount = result.viewCount,
                commentCount = result.commentCount
            )
        }
    }

    override suspend fun postComment(postId:Int, requestCommentPostDto: RequestCommentPostDto): Result<Boolean> {
        return runCatching {
            communityDataSource.postComment(postId,requestCommentPostDto).success
        }
    }

    override suspend fun getPostSearch(
        district: String,
        keyword: String
    ): Result<List<ResponseCommunityPostDto>> {
        return runCatching {
            val response = communityDataSource.getAllPosts(district)
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
