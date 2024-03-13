package com.example.ipz_cw_3_talashuk_taras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ipz_cw_3_talashuk_taras.ui.theme.IPZ_CW_3_Talashuk_TarasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_3_Talashuk_TarasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    CardList()
                }
            }
        }
    }
}

data class DayItem(val day: Int, val title: String, val imageRes: Int, val caption: String)

@Composable
fun DayCard(dayItem: DayItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .background(color = Color.Gray, shape = RoundedCornerShape(9.dp))
    ) {
        Text(text = dayItem.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = dayItem.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)

                .clip(shape = RoundedCornerShape(8.dp)),

            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = dayItem.caption)
    }
}

@Composable
fun CardList() {
    val daysList = generateDaysList()

    LazyColumn {

        items(daysList) { dayItem ->
            DayCard(dayItem = dayItem)
        }
    }
}

@Composable
fun generateDaysList(): List<DayItem> {
    val dayResources = listOf(
        R.drawable.image_day_1, R.drawable.image_day_2, R.drawable.image_day_3,
        R.drawable.image_day_4, R.drawable.image_day_5, R.drawable.image_day_6,
        R.drawable.image_day_7, R.drawable.image_day_8, R.drawable.image_day_9,
        R.drawable.image_day_10
    )

    val dayTitles = listOf(
        "Day 1", "Day 2", "Day 3", "Day 4", "Day 5",
        "Day 6", "Day 7", "Day 8", "Day 9", "Day 10"
    )

    val dayCaptions = listOf(
        "Caption for Day 1", "Caption for Day 2", "Caption for Day 3",
        "Caption for Day 4", "Caption for Day 5", "Caption for Day 6",
        "Caption for Day 7", "Caption for Day 8", "Caption for Day 9",
        "Caption for Day 10"
    )

    return (1..10).mapIndexed { index, day ->
        DayItem(
            day = day,
            title = dayTitles[index % dayTitles.size],
            imageRes = dayResources[index % dayResources.size],
            caption = dayCaptions[index % dayCaptions.size]
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardList() {
    IPZ_CW_3_Talashuk_TarasTheme {
        CardList()
    }
}
