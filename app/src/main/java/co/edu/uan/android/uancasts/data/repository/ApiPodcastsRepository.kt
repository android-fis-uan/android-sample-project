package co.edu.uan.android.uancasts.data.repository

import co.edu.uan.android.uancasts.data.model.Podcast
import co.edu.uan.android.uancasts.data.network.ListenNotesApiService

interface PodcastsRepository {
    suspend fun getPodcasts(): List<Podcast>
}

class ApiPodcastsRepository(
    private val service: ListenNotesApiService
) : PodcastsRepository {
    override suspend fun getPodcasts(): List<Podcast> = service.bestPodcasts().podcasts
}