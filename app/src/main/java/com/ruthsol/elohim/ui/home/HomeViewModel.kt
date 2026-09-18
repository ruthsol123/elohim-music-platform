package com.ruthsol.elohim.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruthsol.elohim.domain.model.Song
import com.ruthsol.elohim.domain.repository.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val musicRepository: MusicRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        musicRepository.getFeaturedSongs()
            .onEach { songs ->
                _uiState.value = HomeUiState.Success(
                    featuredSongs = songs,
                    recentlyPlayed = songs.take(2),
                    popularSongs = songs
                )
            }
            .catch { _uiState.value = HomeUiState.Error("Failed to load music") }
            .launchIn(viewModelScope)
    }
}

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(
        val featuredSongs: List<Song>,
        val recentlyPlayed: List<Song>,
        val popularSongs: List<Song>
    ) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}
