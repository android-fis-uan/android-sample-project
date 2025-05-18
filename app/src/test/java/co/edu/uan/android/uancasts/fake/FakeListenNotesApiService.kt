package co.edu.uan.android.uancasts.fake

import co.edu.uan.android.uancasts.data.model.Podcast
import co.edu.uan.android.uancasts.data.model.PodcastResponse
import co.edu.uan.android.uancasts.data.network.ListenNotesApiService

class FakeListenNotesApiService: ListenNotesApiService {
    override suspend fun bestPodcasts(): PodcastResponse {
        return PodcastResponse("", "", 0, false, FakeDataSource.podcastsList, "", 0, 0, 0)
    }
}