package com.packt.chaptereleven.views

import com.packt.chaptereleven.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)
