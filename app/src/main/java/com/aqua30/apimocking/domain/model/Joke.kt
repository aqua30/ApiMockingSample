package com.aqua30.apimocking.domain.model

data class Joke(
    val id: Int = 0,
    val punchline: String = "",
    val setup: String = "",
    val type: String = ""
)