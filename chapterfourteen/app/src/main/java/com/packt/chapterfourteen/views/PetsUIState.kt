package com.packt.chapterfourteen.views

import com.packt.chapterfourteen.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)