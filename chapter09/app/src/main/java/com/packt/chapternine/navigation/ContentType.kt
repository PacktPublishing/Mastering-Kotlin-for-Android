package com.packt.chapternine.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}