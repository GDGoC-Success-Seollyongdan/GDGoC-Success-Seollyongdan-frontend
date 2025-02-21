package com.example.seollyongdan_frontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seollyongdan_frontend.ui.theme.Gray500
import com.example.seollyongdan_frontend.ui.theme.Info400
import com.example.seollyongdan_frontend.ui.theme.White
import com.example.seollyongdan_frontend.ui.theme.b2Bold
import com.example.seollyongdan_frontend.ui.theme.b3Bold
import com.example.seollyongdan_frontend.ui.theme.b3Semi
import com.example.seollyongdan_frontend.ui.theme.b4Regular
import com.example.seollyongdan_frontend.ui.theme.b4Semi

@Composable
fun CommunityProfileBox(
    communityDistrict : String,
    userDistrict : String,
    userName : String,
    isResident : Boolean,
    time : Int,
){
    val userProfileDistrict = userDistrict.split(" ")[0]
    val time = time.toString()


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(49.dp)

    ){
        UserProfile(userProfileDistrict)

        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Row(
                modifier = Modifier.height(23.dp).padding(top = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(userName, style = b2Bold)

                if (communityDistrict == userDistrict && isResident) {

                    Spacer(modifier = Modifier.width(10.dp))

                    Box(
                        modifier = Modifier
                            .width(50.dp)
                            .height(17.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Info400),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("거주자", style = b4Semi, color = White)
                    }
                }
            }
            Spacer(modifier = Modifier.height(11.dp))
            Text("${time}시간 전", style = b4Regular, color = Gray500)


        }

    }

}

@Preview
@Composable
fun ProfileBoxPreview(){
    CommunityProfileBox(
        communityDistrict = "용산구 청파로2가",
        userDistrict = "용산구 청파로2가",
        userName = "김눈송",
        isResident = false,
        time = 3
    )
}