package com.ruthsol.elohim.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ruthsol.elohim.components.ErrorState
import com.ruthsol.elohim.components.LoadingState
import com.ruthsol.elohim.components.SongCard
import com.ruthsol.elohim.domain.model.Song
import com.ruthsol.elohim.player.manager.MusicPlayerManager

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    playerManager: MusicPlayerManager = hiltViewModel() // Assuming injected
) {
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is HomeUiState.Loading -> LoadingState()
        is HomeUiState.Error -> ErrorState(state.message, onRetry = {})
        is HomeUiState.Success -> {
            HomeContent(
                state = state,
                onSongClick = { song -> playerManager.playSong(song) }
            )
        }
    }
}

@Composable
fun HomeContent(
    state: HomeUiState.Success,
    onSongClick: (Song) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                text = "Elohim",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Discover Worship",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            SectionHeader("Featured Worship")
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(state.featuredSongs) { song ->
                    SongCard(song = song, onClick = { onSongClick(song) })
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            SectionHeader("Recently Played")
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(state.recentlyPlayed) { song ->
                    SongCard(song = song, onClick = { onSongClick(song) })
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
        
        item {
            SectionHeader("Popular")
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                state.popularSongs.forEach { song ->
                    SongCard(
                        song = song, 
                        onClick = { onSongClick(song) },
                        modifier = Modifier.fillMaxWidth().height(100.dp) // Just for variety
                    )
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}
