package com.example.seollyongdan_frontend.presentation.home.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import com.naver.maps.map.overlay.PolygonOverlay
import org.json.JSONObject

@Composable
fun DrawDistrictsOnMap(
    geoJsonString: String,
    Levels: List<String>,
    naverMap: NaverMap
) {
    fun getColorForLevel(level: String): Int {
        return when (level.lowercase()) {
            "high" -> android.graphics.Color.argb(102, 255, 0, 0)    // 40% 투명도의 빨강
            "average" -> android.graphics.Color.argb(102, 0, 255, 0) // 40% 투명도의 초록
            "low" -> android.graphics.Color.argb(102, 255, 235, 59)  // 40% 투명도의 노랑
            else -> android.graphics.Color.argb(102, 128, 128, 128)  // 40% 투명도의 회색
        }
    }

    // 구역 그리기
    LaunchedEffect(geoJsonString, Levels) {
        try {
            val json = JSONObject(geoJsonString)
            val features = json.getJSONArray("features")
            Log.d("폴리곤", "feature 개수 :  ${features.length()}")

            for (i in 0 until features.length()) {
                val feature = features.getJSONObject(i)
                val geometry = feature.getJSONObject("geometry")
                val type = geometry.getString("type")
                val level = if (i in Levels.indices) Levels[i] else "unknown"
                val color = getColorForLevel(level)

                Log.d("폴리곤", "district $i - type: $type, level: $level, color: $color")

                when (type) {
                    "Polygon" -> {
                        val outerRing = geometry.getJSONArray("coordinates").getJSONArray(0)
                        val latLngList = mutableListOf<LatLng>()

                        for (j in 0 until outerRing.length()) {
                            val point = outerRing.getJSONArray(j)
                            latLngList.add(LatLng(point.getDouble(1), point.getDouble(0)))
                        }

                        Log.d("폴리곤", "좌표 리스트 크기: ${latLngList.size}")


                        PolygonOverlay().apply {
                            coords = latLngList
                            this.color = color
                            outlineWidth = 3
                            outlineColor = android.graphics.Color.argb(128, 33, 33, 33)
                            zIndex = 100
                            map = naverMap
                            Log.d("폴리곤", "폴리곤 생성 완료 - 좌표 수: ${latLngList.size}")

                        }
                    }

                    "MultiPolygon" -> {
                        val coordinates = geometry.getJSONArray("coordinates")
                        for (polygonIndex in 0 until coordinates.length()) {
                            val polygon = coordinates.getJSONArray(polygonIndex)
                            val outerRing = polygon.getJSONArray(0)
                            val latLngList = mutableListOf<LatLng>()

                            for (j in 0 until outerRing.length()) {
                                val point = outerRing.getJSONArray(j)
                                latLngList.add(LatLng(point.getDouble(1), point.getDouble(0)))
                            }
                            Log.d("멀티폴리곤", "좌표 리스트 크기: ${latLngList.size}")


                            PolygonOverlay().apply {
                                coords = latLngList
                                this.color = color
                                outlineWidth = 3
                                outlineColor = android.graphics.Color.argb(128, 33, 33, 33)
                                zIndex = 100
                                map = naverMap
                                Log.d("멀티폴리곤", "폴리곤 생성 완료 - 좌표 수: ${latLngList.size}")

                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("DrawDistrictsOnMap", "Error drawing districts", e)
            e.printStackTrace()
        }
    }
}
