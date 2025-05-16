package co.edu.uan.android.uancasts.service

import co.edu.uan.android.uancasts.data.Podcast
import retrofit2.http.GET

interface ListenNotesApiService {

    @GET("best_podcasts")
    suspend fun bestPodcasts() : List<Podcast>

}