package com.packt.chapterthirteen.views

import com.packt.chapterthirteen.data.Cat

data class PetsUIState(
    val isLoading: Boolean = false,
    val pets: List<Cat> = emptyList(),
    val error: String? = null
)