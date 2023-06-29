package com.aqua30.apimocking.data.repository

import android.content.Context
import com.aqua30.apimocking.data.getResponse
import com.aqua30.apimocking.domain.model.Joke
import com.aqua30.apimocking.domain.repository.JokesRepository
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import java.io.IOException
import javax.inject.Inject

/**
 * @author saurabh
 */
const val JokeJsonFile = "jokes.json"

class JokesMockRepository @Inject constructor(
    private val context: Context
): JokesRepository {

    override suspend fun joke(): Joke {
        delay(2000)
        return getResponse(
            context = context,
            jsonName = JokeJsonFile,
            Joke::class.java
        )
//        throw IOException()
    }
}