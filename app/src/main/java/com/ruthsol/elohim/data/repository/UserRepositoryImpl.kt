package com.ruthsol.elohim.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ruthsol.elohim.domain.model.Song
import com.ruthsol.elohim.domain.repository.MusicRepository
import com.ruthsol.elohim.domain.repository.UserRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val musicRepository: MusicRepository
) : UserRepository {

    private val favoritesKey = stringSetPreferencesKey("favorites")

    override fun getFavoriteSongs(): Flow<List<Song>> {
        return context.dataStore.data.map { prefs ->
            prefs[favoritesKey] ?: emptySet()
        }.combine(musicRepository.getFeaturedSongs()) { favIds, allSongs ->
            allSongs.filter { it.id in favIds }
        }
    }

    override suspend fun toggleFavorite(song: Song) {
        context.dataStore.edit { prefs ->
            val current = prefs[favoritesKey] ?: emptySet()
            if (song.id in current) {
                prefs[favoritesKey] = current - song.id
            } else {
                prefs[favoritesKey] = current + song.id
            }
        }
    }

    override fun isFavorite(songId: String): Flow<Boolean> {
        return context.dataStore.data.map { prefs ->
            songId in (prefs[favoritesKey] ?: emptySet())
        }
    }

    override fun getRecentlyPlayed(): Flow<List<Song>> = musicRepository.getRecentlyPlayed()

    override suspend fun addRecentlyPlayed(song: Song) {
        // Implement history persistence if needed
    }
}
