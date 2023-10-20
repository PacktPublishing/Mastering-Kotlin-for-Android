package com.packt.chaptereleven.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}