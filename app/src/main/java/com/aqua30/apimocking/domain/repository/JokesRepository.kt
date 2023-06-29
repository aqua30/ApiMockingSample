package com.aqua30.apimocking.domain.repository

import com.aqua30.apimocking.domain.model.Joke

/**
 * @author saurabh
 */
interface JokesRepository {

    suspend fun joke(): Joke
}