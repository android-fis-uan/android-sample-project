package co.edu.uan.android.uancasts.data.network

import co.edu.uan.android.uancasts.data.model.PodcastResponse
import retrofit2.http.GET

interface ListenNotesApiService {

    @GET("best_podcasts")
    suspend fun bestPodcasts() : PodcastResponse

}