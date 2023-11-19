package com.packt.chapterthirteen.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}