package com.ruthsol.elohim.di

import com.ruthsol.elohim.data.repository.MockMusicRepositoryImpl
import com.ruthsol.elohim.domain.repository.MusicRepository
import com.ruthsol.elohim.domain.repository.UserRepository
import com.ruthsol.elohim.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindMusicRepository(
        impl: MockMusicRepositoryImpl
    ): MusicRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository
}
