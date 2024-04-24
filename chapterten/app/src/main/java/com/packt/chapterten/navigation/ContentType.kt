package com.packt.chapterten.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}