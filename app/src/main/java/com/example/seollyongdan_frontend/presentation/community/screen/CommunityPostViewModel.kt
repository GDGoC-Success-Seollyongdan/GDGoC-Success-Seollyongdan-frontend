package com.example.seollyongdan_frontend.presentation.community.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seollyongdan_frontend.data.dto.response.ResponseCommunityPostDto
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

    init {
        fetchCommunityPosts()
    }

    private fun fetchCommunityPosts() {
        viewModelScope.launch {
            val result = communityRepository.getAllPosts()

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
                _communityPostList.postValue(communityPosts)
            }.onFailure { exception ->
                Log.e("CommunityPostViewModel", "Fail", exception)
            }
        }
    }
}