package com.example.seollyongdan_frontend.presentation.search.navigation

import androidx.navigation.NavController

class SearchNavigator(
    val navController: NavController
){
    fun navigateBack(){
        navController.popBackStack()
    }
    fun navigateToSearchResult(safety : String, traffic : String, real_estate : String, amenities : String ){
        navController.navigate("search_result?safety=${safety}&traffic=${traffic}&real_estate=${real_estate}&amenities=${amenities}")
    }

}