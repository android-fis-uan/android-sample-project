package co.edu.uan.android.uancasts.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.outlined.Forward10
import androidx.compose.material.icons.outlined.Replay10
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.uan.android.uancasts.R
import co.edu.uan.android.uancasts.data.model.Podcast
import co.edu.uan.android.uancasts.data.sampleData
import co.edu.uan.android.uancasts.ui.theme.DarkGrayPanel
import co.edu.uan.android.uancasts.ui.theme.LightGrayPanel
import co.edu.uan.android.uancasts.ui.theme.UANCastsTheme

@Composable
fun ContentPlayerControls(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Replay10,
            contentDescription = "Replay 10",
            modifier = Modifier.size(40.dp),
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Filled.PlayCircle,
            contentDescription = "Play",
            modifier = Modifier.size(72.dp),
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Outlined.Forward10,
            contentDescription = "Forward 10",
            modifier = Modifier.size(40.dp),
            tint = Color.White
        )
    }
}

@Composable
fun ContentInfo(
    episodeTitle: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(episodeTitle,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White
        )
        Text(description,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White)
    }
}

@Composable
fun ContentContainer(
    title: String,
    @DrawableRes image: Int,
    contentName: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    controlsEnabled: Boolean = false
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.Transparent
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            DarkGrayPanel,
                            LightGrayPanel,
                            DarkGrayPanel
                        )
                    )
                ),
        ) {
            Text(title,
                style = MaterialTheme.typography.labelMedium,
                color = Color(0xFFB6AEAE),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.size(140.dp).padding(8.dp),
                )
                Column(
                    modifier = Modifier.padding(8.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ContentInfo(contentName, contentDescription)
                    if (controlsEnabled) {
                        ContentPlayerControls()
                    }
                    else {
                        Box(modifier = Modifier.size(72.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ContentItem(
    podcast: Podcast,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(8.dp)
    )  {
        Text(podcast.title,
            style = MaterialTheme.typography.titleSmall,
            )
        Text(podcast.description,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
            )
        Text("${podcast.totalEpisodes} episodes",
            style = MaterialTheme.typography.bodySmall,
            )
    }
}

@Composable
fun ContentItemCard(
    podcast: Podcast,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
        .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .fillMaxWidth()
        ) {
            Image(
                painterResource(R.drawable.podcast_5), // TODO: Replace with podcast.image
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(93.dp).padding(8.dp),
            )
            ContentItem(podcast, modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Forward 10",
                modifier = Modifier.size(50.dp).padding(8.dp),
                tint = Color.Black
            )
        }
    }
}

@Composable
fun ContentItemList(
    podcasts: List<Podcast>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(1.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        item {
            Text(
                "Most popular",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
        }
        itemsIndexed(podcasts) { index, podcast ->
            ContentItemCard(podcast = podcast)
        }
    }
}


@Preview
@Composable
fun ActivePodcastContainerPreview() {
    UANCastsTheme {
        ContentContainer(
            title = "Recommendations",
            image = R.drawable.podcast_5,
            contentName = "The Vintage RPG Podcast",
            contentDescription = "10 episodes",
            controlsEnabled = false
        )
    }
}

@Preview
@Composable
fun ActiveEpisodeContainerPreview() {
    UANCastsTheme {
        ContentContainer(
            title = "Latest episode",
            image = R.drawable.podcast_3,
            contentName = "Star Wars Galaxy Guides",
            contentDescription = "Episode 1",
            controlsEnabled = true
        )
    }
}

@Preview
@Composable
fun PodcastItemPreview() {
    UANCastsTheme {
        ContentItemCard(
            sampleData.podcasts[1]
        )
    }
}

@Preview
@Composable
fun PodcastListPreview() {
    UANCastsTheme {
        ContentItemList(
            sampleData.podcasts
        )
    }
}