package com.packt.chapterseven.characters

sealed interface NavigationOptions{
    object NavigationRail: NavigationOptions
    object BottomNavigation: NavigationOptions
    object NavigationDrawer: NavigationOptions
}