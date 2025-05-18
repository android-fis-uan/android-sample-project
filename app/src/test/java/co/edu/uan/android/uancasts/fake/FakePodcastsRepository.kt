package co.edu.uan.android.uancasts.fake

import co.edu.uan.android.uancasts.data.model.Podcast
import co.edu.uan.android.uancasts.data.repository.PodcastsRepository

class FakePodcastsRepository: PodcastsRepository {
    override suspend fun getPodcasts(): List<Podcast> {
        return FakeDataSource.podcastsList
    }
}