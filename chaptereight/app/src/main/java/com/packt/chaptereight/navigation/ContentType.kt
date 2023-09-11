package com.packt.chaptereight.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}