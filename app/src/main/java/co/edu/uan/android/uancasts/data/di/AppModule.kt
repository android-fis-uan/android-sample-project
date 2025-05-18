package co.edu.uan.android.uancasts.data.di

import co.edu.uan.android.uancasts.data.network.ListenNotesApiService
import co.edu.uan.android.uancasts.data.repository.ApiPodcastsRepository
import co.edu.uan.android.uancasts.data.repository.PodcastsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private val baseUrl = "https://listen-api-test.listennotes.com/api/v2/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @Provides
    @Singleton
    fun provideListenNotesApiService(retrofit: Retrofit): ListenNotesApiService = retrofit.create(ListenNotesApiService::class.java)

    @Provides
    @Singleton
    fun providePodcastsRepository(retrofitService: ListenNotesApiService): PodcastsRepository = ApiPodcastsRepository(retrofitService)

}