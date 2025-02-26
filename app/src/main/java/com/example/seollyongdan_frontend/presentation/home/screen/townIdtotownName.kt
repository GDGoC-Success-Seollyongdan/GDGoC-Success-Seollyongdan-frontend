package com.example.seollyongdan_frontend.presentation.home.screen

import androidx.compose.runtime.Composable

@Composable
fun townIdToTownName(townId : Int) : String {
    return when (townId){
        1 -> "강남구"
        2 -> "강동구"
        3 -> "강북구"
        4 -> "강서구"
        5 -> "관악구"
        6 -> "광진구"
        7 -> "구로구"
        8 -> "금천구"
        9 -> "노원구"
        10 -> "도봉구"
        11 -> "동대문구"
        12 -> "동작구"
        13 -> "마포구"
        14 -> "서대문구"
        15 -> "서초구"
        16 -> "성동구"
        17 -> "성북구"
        18 -> "송파구"
        19 -> "양천구"
        20 -> "영등포구"
        21 -> "용산구"
        22 -> "은평구"
        23 -> "종로구"
        24 -> "중구"
        25 -> "중랑구"
        else -> "알 수 없음"
    }
}

@Composable
fun townNameToId(townName: String): Int {
    return when (townName) {
        "강남구" -> 1
        "강동구" -> 2
        "강북구" -> 3
        "강서구" -> 4
        "관악구" -> 5
        "광진구" -> 6
        "구로구" -> 7
        "금천구" -> 8
        "노원구" -> 9
        "도봉구" -> 10
        "동대문구" -> 11
        "동작구" -> 12
        "마포구" -> 13
        "서대문구" -> 14
        "서초구" -> 15
        "성동구" -> 16
        "성북구" -> 17
        "송파구" -> 18
        "양천구" -> 19
        "영등포구" -> 20
        "용산구" -> 21
        "은평구" -> 22
        "종로구" -> 23
        "중구" -> 24
        "중랑구" -> 25
        else -> -1  // 알 수 없는 값은 -1 반환
    }
}
