package com.packt.chapterfifteen.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}
