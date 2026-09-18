package com.ruthsol.elohim.ui.lyrics

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruthsol.elohim.domain.model.LyricLine

@Composable
fun LyricsView(
    lyrics: List<LyricLine>,
    currentPosition: Long,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    
    // Find current line index
    val currentIndex = lyrics.indexOfLast { it.timestamp <= currentPosition }.coerceAtLeast(0)

    LaunchedEffect(currentIndex) {
        if (lyrics.isNotEmpty()) {
            listState.animateScrollToItem(currentIndex)
        }
    }

    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        itemsIndexed(lyrics) { index, line ->
            val isCurrent = index == currentIndex
            Text(
                text = line.content,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = if (isCurrent) 28.sp else 22.sp,
                    fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                    color = if (isCurrent) MaterialTheme.colorScheme.primary 
                            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp)
            )
        }
    }
}
