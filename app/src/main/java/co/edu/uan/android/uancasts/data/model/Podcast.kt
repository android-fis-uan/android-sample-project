package co.edu.uan.android.uancasts.data.model

import co.edu.uan.android.uancasts.R
import com.google.gson.annotations.SerializedName

data class Podcast(
    val id: String = "",
    val title: String,
    @Transient
    val image: Int = R.drawable.podcast_5,
    val thumbnail: String = "",
    val description: String,
    @SerializedName("total_episodes")
    val totalEpisodes: Int = 0,
    @Transient
    val episodes: List<Episode> = emptyList<Episode>()
)

data class Episode(
    val title: String,
    val description: String,
    val duration: String,
    val date: String
)

data class PodcastResponse(
    val id: String,
    val name: String,
    val total: Int,
    val has_next: Boolean,
    val podcasts: List<Podcast>,
    val parent_id: String,
    val page_number: Int,
    val next_page_number: Int,
    val prev_page_number: Int
)