# ELOHIM - Amharic Protestant Worship App

ELOHIM is a modern Android application dedicated to discovering and streaming Amharic Protestant worship songs. Built with a focus on premium user experience and clean architecture, it serves as a platform for spiritual connection through music and lyrics.

## Features

- **Modern Home Dashboard**: Personalized welcome and featured worship content.
- **Advanced Audio Playback**: High-quality streaming with background playback support using Android Media3.
- **Synchronized Lyrics**: Real-time Amharic Unicode lyrics scrolling with the music.
- **Smart Search**: Find your favorite worship songs, artists, and albums instantly.
- **Personal Library**: Manage favorites and track your recently played songs.
- **Premium UI/UX**: Distinctly Ethiopian-inspired Material 3 design with Dark and Light mode support.
- **Adaptive Layout**: Optimized for various screen sizes, from small phones to tablets.

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose (100% Declarative UI)
- **Architecture**: Clean Architecture (MVVM + Repository Pattern)
- **Dependency Injection**: Dagger Hilt
- **Media Playback**: AndroidX Media3 / ExoPlayer
- **Async & Streams**: Kotlin Coroutines & Flow
- **Image Loading**: Coil
- **Local Persistence**: Jetpack DataStore
- **Build System**: Gradle Kotlin DSL with Version Catalog

## Project Structure

```text
com.ruthsol.elohim/
├── data/           # Repository implementations, local data sources
├── domain/         # Models, repository interfaces, use cases
├── player/         # Media3 Service and Manager
├── ui/             # Compose screens, view models, and design system
│   ├── components/ # Reusable UI components
│   ├── theme/      # Material 3 colors, typography, and themes
│   └── navigation/ # Navigation definitions and logic
└── di/             # Hilt modules
```

## Setup & Running

1. Clone the repository:
   ```bash
   git clone https://github.com/ruthsol123/elohim.git
   ```
2. Open the project in **Android Studio Ladybug (2024.2.1)** or newer.
3. Sync the project with Gradle files.
4. Run the app on an emulator or physical device (API 24+).

## Future Roadmap

- [ ] REST API Integration for live content.
- [ ] Offline downloads for worship on the go.
- [ ] User authentication and cloud sync for favorites.
- [ ] Artist profiles and album collections.

## Licensing

- **Audio**: Uses royalty-free sample audio for development purposes.
- **Lyrics**: Amharic worship lyrics used are for demonstration and are intended for public domain use.
- **Images**: Unsplash royalty-free images for artwork placeholders.

---
*Created for a professional GitHub portfolio by Ruth Sol.*
