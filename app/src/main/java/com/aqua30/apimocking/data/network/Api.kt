package com.aqua30.apimocking.data.network

import com.aqua30.apimocking.domain.model.Joke
import retrofit2.http.GET

/**
 * @author saurabh
 */
interface Api {

    @GET("random_joke")
    suspend fun joke(): Joke
}