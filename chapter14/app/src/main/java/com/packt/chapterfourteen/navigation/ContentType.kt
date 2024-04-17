package com.packt.chapterfourteen.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}
