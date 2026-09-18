package com.ruthsol.elohim.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ruthsol.elohim.components.EmptyState
import com.ruthsol.elohim.components.SongListItem
import com.ruthsol.elohim.ui.player.PlayerViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel(),
    playerViewModel: PlayerViewModel = hiltViewModel()
) {
    val query by viewModel.query.collectAsState()
    val results by viewModel.searchResults.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = query,
            onValueChange = { viewModel.onQueryChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Search songs, artists...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true
        )

        if (results.isEmpty() && query.isNotEmpty()) {
            EmptyState("No results found for \"$query\"")
        } else if (results.isEmpty()) {
            EmptyState("Search for your favorite worship songs")
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(results) { song ->
                    SongListItem(
                        song = song,
                        onClick = { playerViewModel.playSong(song) }
                    )
                }
            }
        }
    }
}
