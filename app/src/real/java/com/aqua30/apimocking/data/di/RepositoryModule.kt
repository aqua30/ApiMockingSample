package com.aqua30.apimocking.data.di

import com.aqua30.apimocking.data.repository.JokesRepositoryImpl
import com.aqua30.apimocking.domain.repository.JokesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author saurabh
 */
@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun jokeRepository(impl: JokesRepositoryImpl): JokesRepository
}