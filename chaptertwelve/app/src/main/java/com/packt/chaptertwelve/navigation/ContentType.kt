package com.packt.chaptertwelve.navigation

sealed interface ContentType {
    object List : ContentType
    object ListAndDetail : ContentType
}