package com.ruthsol.elohim.domain.model

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val album: String,
    val artworkUrl: String,
    val audioUrl: String,
    val duration: Long,
    val category: String,
    val lyrics: List<LyricLine>? = null
)

data class LyricLine(
    val timestamp: Long,
    val content: String
)

data class Artist(
    val id: String,
    val name: String,
    val imageUrl: String,
    val bio: String
)

data class Album(
    val id: String,
    val title: String,
    val artist: String,
    val artworkUrl: String,
    val releaseYear: Int
)

data class Category(
    val id: String,
    val name: String,
    val imageUrl: String
)
