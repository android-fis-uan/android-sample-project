package co.edu.uan.android.uancasts.data

import co.edu.uan.android.uancasts.service.ListenNotesApiService

interface PodcastsRepository {
    suspend fun getPodcasts(): List<Podcast>
}

class ApiPodcastsRepository(
    private val service: ListenNotesApiService
) : PodcastsRepository {
    override suspend fun getPodcasts(): List<Podcast> = service.bestPodcasts()
}