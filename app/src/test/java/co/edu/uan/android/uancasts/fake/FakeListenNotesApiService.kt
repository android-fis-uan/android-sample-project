package co.edu.uan.android.uancasts.fake

import co.edu.uan.android.uancasts.data.model.PodcastResponse
import co.edu.uan.android.uancasts.data.network.ListenNotesApiService

class FakeListenNotesApiService: ListenNotesApiService {
    override suspend fun bestPodcasts(): PodcastResponse {
        return FakeDataSource.podcastsList
    }
}