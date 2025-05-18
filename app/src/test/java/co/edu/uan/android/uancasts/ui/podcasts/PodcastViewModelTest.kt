package co.edu.uan.android.uancasts.ui.podcasts

import co.edu.uan.android.uancasts.fake.FakeDataSource
import co.edu.uan.android.uancasts.fake.FakePodcastsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class PodcastViewModelTest {

    @org.junit.Test
    fun `getPodcasts initial state is Loading`() {
        // Verify that immediately after calling getPodcasts, podcastsUiState is set to PodcastsUiState.Loading.
        // TODO implement test
    }

    @org.junit.Test
    fun `getPodcasts success state`() {
        runTest {
            // Given the repository.getPodcasts() returns a successful list of podcasts,
            var viewModel = PodcastViewModel(FakePodcastsRepository())
            // When getPodcasts() is called,
            viewModel.getPodcasts()
            // Then podcastsUiState should be PodcastsUiState.Success with the returned podcasts.
            advanceUntilIdle()
            assertEquals(PodcastsUiState(podcasts = FakeDataSource.podcastsList), viewModel.podcastsUiState)
        }
    }

    @org.junit.Test
    fun `getPodcasts error state`() {
        // Given the repository.getPodcasts() throws an exception,
//        runTest {
//            val service = Retrofit.Builder()
//
//                .baseUrl("https://listen-api-test.listennotes.com/api/v2/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(ListenNotesApiService::class.java)
//
//            val data = service.bestPodcasts()
//            println(data)
//        }
        // When getPodcasts() is called,

        // Then podcastsUiState should be PodcastsUiState.Error.
        // TODO implement test
    }

    @org.junit.Test
    fun `getPodcasts empty list success state`() {
        // Given the repository.getPodcasts() returns an empty list,

        // When getPodcasts() is called,

        // Then podcastsUiState should be PodcastsUiState.Success with an empty list.
        // TODO implement test
    }

    @org.junit.Test
    fun `getPodcasts multiple calls preserves latest state`() {
        // Given getPodcasts() is called once and results in Success,

        // When getPodcasts() is called again and results in Error,

        // Then podcastsUiState should be PodcastsUiState.Error.
        // TODO implement test
    }

    @org.junit.Test
    fun `getPodcasts coroutine cancellation`() {
        // Given the viewModelScope's coroutine is cancelled while repository.getPodcasts() is executing,

        // When getPodcasts() is called,

        // Then the podcastsUiState should ideally remain in Loading or the state prior to cancellation, and not crash.
        // TODO implement test
    }

    @org.junit.Test
    fun `getPodcasts repository returns null  if applicable `() {
        // If the repository.getPodcasts() contract allows returning null (though generally not good practice with Kotlin collections),

        // When getPodcasts() is called and repository returns null,

        // Then podcastsUiState should be PodcastsUiState.Error (or handle as per specific error handling for nulls if different).
        // TODO implement test
    }

    @org.junit.Test
    fun `getPodcasts viewmodel initialization triggers getPodcasts`() {
        // When the PodcastViewModel is initialized,

        // Then the getPodcasts() method should be called, and podcastsUiState should eventually transition from Loading to either Success or Error.
        // TODO implement test
    }

    @org.junit.Test
    fun `getPodcasts with specific exception types`() {
        // Given the repository.getPodcasts() throws a specific type of exception (e.g., IOException, HttpException),

        // When getPodcasts() is called,

        // Then podcastsUiState should be PodcastsUiState.Error, and potentially log the specific exception if logging is implemented.
        // TODO implement test
    }
}