package com.example.beer.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.beer.domain.Beer
import com.example.beer.ui.theme.BeerTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = beer.imageUrl,
                    contentDescription = beer.name,
                    modifier = Modifier
                        .height(150.dp)
                        // 해당 옵션을 지정해주지 않으면 이미지가 가운데 정렬이 되지 않음
                        // 지정해주지 않으면 원래 크기로 설정(intrinsic size)되어
                        // 이미지가 Row의 왼쪽부터 시작하여 원래 크기로 보여지게 됨, 따라서 왼쪽으로 치우쳐서 보일 수 있음
                        // 가로로 꽉차게 하여 이미지가 왼쪽으로 치우치지 않고 가로 방향으로 균등하게 퍼져 보이게
                        .fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = beer.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.tagline,
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier.height(8.dp))
                Text(
                    text = beer.description,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier.height(8.dp))
                Text(
                    text = "First brewed in ${beer.firstBrewed}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 8.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun BeerItemPreview() {
    BeerTheme {
        BeerItem(
            beer = Beer(
                id = 1,
                name = "Beer",
                tagline = "This is a cool beer",
                firstBrewed = "07/2023",
                description = "This is a description for a beer. \nThis is the next line",
                imageUrl = null
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}