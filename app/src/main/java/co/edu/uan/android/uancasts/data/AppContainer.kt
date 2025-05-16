package co.edu.uan.android.uancasts.data

import co.edu.uan.android.uancasts.service.ListenNotesApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue

interface AppContainer {
    val podcastsRepository: PodcastsRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://listen-api.listennotes.com/api/v2/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: ListenNotesApiService by lazy {
        retrofit.create(ListenNotesApiService::class.java)
    }

    override val podcastsRepository: PodcastsRepository by lazy {
        ApiPodcastsRepository(retrofitService)
    }
}