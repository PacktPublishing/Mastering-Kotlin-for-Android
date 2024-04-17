package com.packt.chaptertwelve.views

import com.packt.chaptertwelve.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)