package co.edu.uan.android.uancasts.ui.podcasts

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.uan.android.uancasts.data.model.Podcast
import co.edu.uan.android.uancasts.data.repository.PodcastsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PodcastsUiState(
    val isLoading: Boolean = true,
    val podcasts: List<Podcast> = emptyList<Podcast>(),
    val errorMessage: String? = null
) {
}

@HiltViewModel
class PodcastViewModel @Inject constructor(
    private val repository: PodcastsRepository
) : ViewModel() {

    var podcastsUiState: PodcastsUiState by mutableStateOf(PodcastsUiState())
        private set

    init {
        getPodcasts()
    }

    fun getPodcasts() {
        viewModelScope.launch {
            //podcastsUiState = PodcastsUiState.Loading
            podcastsUiState = try {
                PodcastsUiState(isLoading = false, podcasts = repository.getPodcasts())
            } catch (e: Exception) {
                Log.e("PodcastViewModel", "Error fetching podcasts", e)
                PodcastsUiState(errorMessage = "Error fetching podcasts")
            }
        }
    }

}