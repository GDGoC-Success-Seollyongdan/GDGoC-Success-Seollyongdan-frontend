package com.example.seollyongdan_frontend.presentation.community.screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.data.dto.request.RequestCommentPostDto
import com.example.seollyongdan_frontend.data.dto.request.RequestCommunityNewPostDto
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostCommentDto
import com.example.seollyongdan_frontend.domain.repository.CommunityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommunityPostViewModel @Inject constructor(
    private val communityRepository: CommunityRepository
) : ViewModel() {

    private val _communityPostList = MutableLiveData<List<CommunityPostEntity>>()
    val communityPostList: LiveData<List<CommunityPostEntity>> = _communityPostList

    private val _communityPostDetail = MutableLiveData<CommunityPostEntity>()
    val communityPostDetail: LiveData<CommunityPostEntity> = _communityPostDetail

    private val _postCommentsList = MutableLiveData<List<ResponseCommunityPostCommentDto>>()
    val postCommentsList: LiveData<List<ResponseCommunityPostCommentDto>> = _postCommentsList

    private val _isCommentPostSuccess = mutableStateOf<Boolean?>(null) //회원가입 성공 여부 screen에게 알려줌
    val isCommentPostSuccess: State<Boolean?> = _isCommentPostSuccess

    private val _searchPostList = MutableLiveData<List<CommunityPostEntity>>()
    val searchPostList: LiveData<List<CommunityPostEntity>> = _searchPostList

    fun getCommunityPosts(district: String) {
        viewModelScope.launch {
            val result = communityRepository.getAllPosts(district)

            result.onSuccess { posts ->
                val communityPosts = posts.map { post ->
                    CommunityPostEntity(
                        id = post.postId,
                        userName = post.postNickname,
                        userDistrict = post.userDistrick,
                        postDistrict = post.postDistrict,
                        isResident = post.isResident,
                        title = post.title,
                        content = post.content,
                        postTime = post.postTime,
                        like = post.likeCount,
                        view = post.viewCount,
                        comment = post.commentCount
                    )
                }
                _communityPostList.postValue(communityPosts.reversed())
            }.onFailure { exception ->
                Log.e("CommunityPostViewModel", "Fail", exception)
            }
        }
    }

    fun getCommunityPostDetail(postId: Int) {
        viewModelScope.launch {
            val result = communityRepository.getPostDetail(postId)

            result.onSuccess { result ->
                if (result != null){

                    _communityPostDetail.value = CommunityPostEntity(
                        id = result.postId,
                        userName = result.postNickname,
                        userDistrict = result.userDistrick,
                        postDistrict = result.postDistrict,
                        isResident = result.isResident,
                        title = result.title,
                        content = result.content,
                        postTime = result.postTime,
                        like = result.likeCount,
                        view = result.viewCount,
                        comment = result.commentCount
                    )
                }

            }.onFailure { exception ->
                Log.e("CommunityPostViewModel", "Fail", exception)
            }
        }
    }


    fun getCommunityPostComments(postId: Int) {
        viewModelScope.launch {
            val result = communityRepository.getPostComment(postId)

            result.onSuccess { comments ->
                val postComments = comments.map { comment ->
                    ResponseCommunityPostCommentDto(
                        commentId = comment.commentId,
                        content = comment.content
                    )

                }
                _postCommentsList.postValue(postComments)

            }.onFailure {
            }
        }
    }


    fun postComment(content: String, postId: Int) {

        val requestCommentPostDto = RequestCommentPostDto(content)

        viewModelScope.launch {
            val result = communityRepository.postComment(postId, requestCommentPostDto)
            result.onSuccess { response ->
                if (response == true) {
                    _isCommentPostSuccess.value = true
                    getCommunityPostComments(postId)
                }

            }

        }
    }

    fun getPostSearch(district: String, keyword : String) {
        viewModelScope.launch {
            val result = communityRepository.getPostSearch(district, keyword)

            result.onSuccess { posts ->
                val communityPosts = posts.map { post ->
                    CommunityPostEntity(
                        id = post.postId,
                        userName = post.postNickname,
                        userDistrict = post.userDistrick,
                        postDistrict = post.postDistrict,
                        isResident = post.isResident,
                        title = post.title,
                        content = post.content,
                        postTime = post.postTime,
                        like = post.likeCount,
                        view = post.viewCount,
                        comment = post.commentCount
                    )
                }
                _searchPostList.postValue(communityPosts)
            }.onFailure { exception ->
                Log.e("CommunityPostViewModel", "Fail", exception)
            }
        }
    }


}