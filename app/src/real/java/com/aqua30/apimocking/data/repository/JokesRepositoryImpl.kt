package com.aqua30.apimocking.data.repository

import com.aqua30.apimocking.data.network.Api
import com.aqua30.apimocking.domain.model.Joke
import com.aqua30.apimocking.domain.repository.JokesRepository
import javax.inject.Inject

/**
 * @author saurabh
 */
class JokesRepositoryImpl @Inject constructor(
    private val remoteSource: Api,
): JokesRepository {

    override suspend fun joke(): Joke {
        return remoteSource.joke()
    }
}