package co.edu.uan.android.uancasts.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.edu.uan.android.uancasts.R
import co.edu.uan.android.uancasts.data.sampleData
import co.edu.uan.android.uancasts.ui.theme.UANCastsTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box (modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column {
            ContentContainer(
                title = "Recommendations",
                image = R.drawable.podcast_5,
                contentName = "The Vintage RPG Podcast",
                contentDescription = "10 episodes",
                controlsEnabled = false
            )
            ContentItemList(
                sampleData
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    UANCastsTheme {
        HomeScreen()
    }
}