package com.ruthsol.elohim.domain.repository

import com.ruthsol.elohim.domain.model.Song
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getFavoriteSongs(): Flow<List<Song>>
    suspend fun toggleFavorite(song: Song)
    fun isFavorite(songId: String): Flow<Boolean>
    
    fun getRecentlyPlayed(): Flow<List<Song>>
    suspend fun addRecentlyPlayed(song: Song)
}
