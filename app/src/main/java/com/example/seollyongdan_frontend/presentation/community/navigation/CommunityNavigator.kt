package com.example.seollyongdan_frontend.presentation.community.navigation

import androidx.navigation.NavController

class CommunityNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }

    fun navigateToCommunity(){
        navController.navigate("community")
    }

    fun navigateToCommunitySearch(district: String){
        navController.navigate("communitySearch?district=${district}")
    }

    fun navigateToCommunityReview(district : String){
        navController.navigate("communityReview?district=${district}")
    }

    fun navigateToCommunityWrite(district: String){
        navController.navigate("communityWrite?district=${district}")
    }

    fun navigateToCommunityDetail(id : Int, district: String){
        navController.navigate("communityDetail?id=${id}?district=${district}")
    }
}