package com.ruthsol.elohim.ui.player

import androidx.lifecycle.ViewModel
import com.ruthsol.elohim.domain.model.Song
import com.ruthsol.elohim.player.manager.MusicPlayerManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val playerManager: MusicPlayerManager
) : ViewModel() {

    val currentSong = playerManager.currentSong
    val isPlaying = playerManager.isPlaying
    val currentPosition = playerManager.currentPosition
    val duration = playerManager.duration

    fun playSong(song: Song) = playerManager.playSong(song)
    fun togglePlayPause() = playerManager.togglePlayPause()
    fun seekTo(position: Long) = playerManager.seekTo(position)
    fun skipToNext() = playerManager.skipToNext()
    fun skipToPrevious() = playerManager.skipToPrevious()
}
