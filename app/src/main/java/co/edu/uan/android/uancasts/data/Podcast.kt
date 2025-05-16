package co.edu.uan.android.uancasts.data

import com.google.gson.annotations.SerializedName

data class Podcast(
    val id: String = "",
    val title: String,
    @Transient
    val image: Int,
    val thumbnail: String = "",
    val description: String,
    @SerializedName("total_episodes")
    val totalEpisodes: Int = 0,
    @Transient
    val episodes: List<Episode>
) {
}

data class Episode(
    val title: String,
    val description: String,
    val duration: String,
    val date: String
) {}