package com.aqua30.apimocking.data

import android.content.Context
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException

/**
 * @author saurabh
 */
fun <T> getResponse(@ApplicationContext context: Context, jsonName: String, cls: Class<T>): T {
    val gson = Gson()
    return gson.fromJson(
        json(context, jsonName),
        cls
    )
}

private fun json(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString

}