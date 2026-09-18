package com.ruthsol.elohim.domain.repository

import com.ruthsol.elohim.domain.model.*
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun getFeaturedSongs(): Flow<List<Song>>
    fun getRecentlyPlayed(): Flow<List<Song>>
    fun getPopularSongs(): Flow<List<Song>>
    fun searchSongs(query: String): Flow<List<Song>>
    fun getSongById(id: String): Flow<Song?>
    fun getCategories(): Flow<List<Category>>
    fun getArtists(): Flow<List<Artist>>
    fun getAlbums(): Flow<List<Album>>
}
