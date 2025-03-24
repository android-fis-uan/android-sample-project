package co.edu.uan.android.uancasts.data

data class Podcast(
    val title: String,
    val image: Int,
    val description: String,
    val episodes: List<Episode>
) {
}

data class Episode(
    val title: String,
    val description: String,
    val duration: String,
    val date: String
) {}