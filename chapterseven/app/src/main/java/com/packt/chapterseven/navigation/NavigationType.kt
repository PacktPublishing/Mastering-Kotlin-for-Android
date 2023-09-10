package com.packt.chapterseven.navigation

sealed interface NavigationType {
    object BottomNavigation : NavigationType
    object NavigationDrawer : NavigationType
    object NavigationRail : NavigationType
}