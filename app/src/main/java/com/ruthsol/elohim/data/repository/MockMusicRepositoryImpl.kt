package com.ruthsol.elohim.data.repository

import com.ruthsol.elohim.domain.model.*
import com.ruthsol.elohim.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class MockMusicRepositoryImpl @Inject constructor() : MusicRepository {

    private val sampleSongs = listOf(
        Song(
            id = "1",
            title = "ያለህበት (Yalehibet)",
            artist = "Yishak Sedik",
            album = "Single",
            artworkUrl = "https://images.unsplash.com/photo-1511671782779-c97d3d27a1d4?w=500&h=500&fit=crop",
            audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
            duration = 240000,
            category = "Worship",
            lyrics = listOf(
                LyricLine(0, "ያለህበት ቦታ ሁሉ የተቀደሰ ነው"),
                LyricLine(8000, "ግርማህ ይከባል በፊቴ ቆሜያለሁ"),
                LyricLine(16000, "ቅዱስ ቅዱስ ቅዱስ እያልኩ አመልካለሁ")
            )
        ),
        Song(
            id = "2",
            title = "እወድሃለሁ (Ewedihalehu)",
            artist = "Tekesta Getnet",
            album = "Album 1",
            artworkUrl = "https://images.unsplash.com/photo-1470225620780-dba8ba36b745?w=500&h=500&fit=crop",
            audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3",
            duration = 300000,
            category = "Praise",
            lyrics = listOf(
                LyricLine(0, "እወድሃለሁ ጌታ ሆይ እወድሃለሁ"),
                LyricLine(10000, "በምስጋና ፊትህ እቆማለሁ")
            )
        ),
        Song(
            id = "3",
            title = "አንተ ብቻ (Ante Bicha)",
            artist = "Ephrem Alemu",
            album = "Single",
            artworkUrl = "https://images.unsplash.com/photo-1493225255756-d9584f8606e9?w=500&h=500&fit=crop",
            audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3",
            duration = 180000,
            category = "Contemporary",
            lyrics = listOf(
                LyricLine(0, "አንተ ብቻ ነህ የነፍሴ መጠጊያ"),
                LyricLine(12000, "በጥላህ ስር አለኝ እረፍትና ሰላም")
            )
        )
    )

    override fun getFeaturedSongs(): Flow<List<Song>> = flowOf(sampleSongs)
    override fun getRecentlyPlayed(): Flow<List<Song>> = flowOf(sampleSongs.take(2))
    override fun getPopularSongs(): Flow<List<Song>> = flowOf(sampleSongs)
    override fun searchSongs(query: String): Flow<List<Song>> = flowOf(
        sampleSongs.filter { it.title.contains(query, ignoreCase = true) || it.artist.contains(query, ignoreCase = true) }
    )
    override fun getSongById(id: String): Flow<Song?> = flowOf(sampleSongs.find { it.id == id })
    override fun getCategories(): Flow<List<Category>> = flowOf(
        listOf(
            Category("1", "Worship", "https://images.unsplash.com/photo-1445985543470-41fba5c3144a?w=200&h=200&fit=crop"),
            Category("2", "Praise", "https://images.unsplash.com/photo-1510915228340-29c85a43dcfe?w=200&h=200&fit=crop"),
            Category("3", "Contemporary", "https://images.unsplash.com/photo-1514525253344-f814d074e015?w=200&h=200&fit=crop")
        )
    )
    override fun getArtists(): Flow<List<Artist>> = flowOf(emptyList())
    override fun getAlbums(): Flow<List<Album>> = flowOf(emptyList())
}
