# Elohim

Elohim is a modern Android music platform for discovering and streaming Amharic Protestant worship music with synchronized lyrics. Built for a premium mobile experience, it combines distinctly Ethiopian aesthetics with high-performance audio playback.

## Overview

ELOHIM (Hebrew for "God") is designed as a professional portfolio project demonstrating clean architecture, advanced media handling, and modern Jetpack Compose UI patterns. It provides a seamless way for users to engage with spiritual music, offering high-quality audio streaming and real-time lyric synchronization.

## Features

- **Home Dashboard**: Personalized discovery with featured worship, recently played, and popular songs.
- **Advanced Audio Playback**: Background-aware streaming powered by **AndroidX Media3 (ExoPlayer)**.
- **Synchronized Lyrics**: Real-time Amharic Unicode lyrics that scroll and highlight in sync with the music.
- **Smart Search**: Instant filtering by song title, artist, or album using a repository-based search engine.
- **Personal Library**: Manage favorite worship songs and track playback history.
- **Modern UI/UX**: A "Midnight Gold" design system utilizing **Material 3**, with full support for Light and Dark modes.
- **Adaptive Design**: Responsive layouts that optimize for various screen sizes, from compact phones to tablets.
- **Accessibility**: Optimized touch targets, content descriptions, and semantic UI for screen readers.

## Technology Stack

- **Kotlin**: Primary language for robust and expressive code.
- **Jetpack Compose**: 100% declarative UI toolkit.
- **Material 3**: Latest Material Design components and theming.
- **Dagger Hilt**: Standardized dependency injection.
- **Kotlin Coroutines & Flow**: Asynchronous programming and reactive data streams.
- **AndroidX Media3 / ExoPlayer**: High-level media playback and session management.
- **Navigation Compose**: Type-safe navigation between screens.
- **Coil**: Image loading with caching and smooth transitions.
- **DataStore**: Local preferences and user state persistence.
- **Gradle Kotlin DSL**: Modern build configuration with Version Catalog.

## Architecture

ELOHIM follows **Clean Architecture** principles to ensure maintainability and testability:

- **UI Layer**: Composable screens and ViewModels (MVVM) managing UI state.
- **Domain Layer**: Core business logic, models, and repository interfaces.
- **Data Layer**: Repository implementations, local data sources (Mock/DataStore), and future API integration points.

The architecture is designed to be **API-ready**, allowing the current local data layer to be seamlessly replaced with a REST backend or Firebase implementation.

## Project Structure

```text
Elohim/
├── app/
│   ├── src/main/java/com/ruthsol/elohim/
│   │   ├── components/    # Reusable UI components
│   │   ├── data/          # Repository implementations
│   │   ├── di/            # Dependency injection modules
│   │   ├── domain/        # Models and interfaces
│   │   ├── navigation/    # App routing and screens
│   │   ├── player/        # Media3 Service and Manager
│   │   ├── ui/            # Compose screens and themes
│   │   └── utils/         # Helper functions
│   └── AndroidManifest.xml
├── gradle/                # Dependency version catalog
├── build.gradle.kts       # Project-level build script
├── settings.gradle.kts    # Project settings
└── README.md
```

## Core Functionality

### Audio Playback System
Uses a centralized `MediaSessionService` to provide seamless playback that continues when the app is in the background. The `MusicPlayerManager` provides a `StateFlow` interface for UI components to observe playback status, progress, and current metadata.

### Lyrics System
A custom synchronization engine maps timestamps to lyric lines. The `LyricsView` automatically scrolls and highlights the active line based on the `ExoPlayer` position.

## Screenshots

Screenshots will be added after the first stable release.

## Setup & Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ruthsol123/elohim-music-platform.git
   ```
2. **Open in Android Studio**:
   Import the project in Android Studio Ladybug (2024.2.1) or newer.
3. **Gradle Sync**:
   Wait for the project to sync dependencies from the Version Catalog.

## Running the Project

1. Select an Android emulator (API 24+) or a physical device.
2. Ensure you have an internet connection for image loading (Coil).
3. Click the **Run** button in Android Studio.

## Sample Data & Licensing

- **Audio**: Royalty-free sample tracks are used for development.
- **Lyrics**: Original or public-domain Amharic worship lyrics.
- **Images**: High-quality placeholders from Unsplash.
- **License**: This project is licensed under the MIT License.

## Future Improvements

- [ ] RESTful API integration for dynamic content updates.
- [ ] Offline download functionality.
- [ ] User authentication (Firebase/Auth0).
- [ ] Collaborative playlists and community features.

## Author

**Ruth Sol**
[GitHub Profile](https://github.com/ruthsol123)
