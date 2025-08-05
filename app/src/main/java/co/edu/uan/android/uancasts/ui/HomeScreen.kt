package co.edu.uan.android.uancasts.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import co.edu.uan.android.uancasts.R
import co.edu.uan.android.uancasts.ui.podcasts.PodcastViewModel
import co.edu.uan.android.uancasts.ui.theme.UANCastsTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewmodel: PodcastViewModel = hiltViewModel<PodcastViewModel>(),
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        ContentContainer(
            title = "Recommendations",
            image = R.drawable.podcast_5,
            contentName = "The Vintage RPG Podcast",
            contentDescription = "10 episodes",
            controlsEnabled = false
        )
        ContentItemList(
            viewmodel.podcastsUiState.podcasts,
            modifier = Modifier.weight(1f) // using weight to fix issue when using LazyColumn inside a Column
        )
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    UANCastsTheme {
        HomeScreen()
    }
}