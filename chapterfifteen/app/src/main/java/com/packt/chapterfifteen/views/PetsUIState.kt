package com.packt.chapterfifteen.views

import com.packt.chapterfifteen.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)
