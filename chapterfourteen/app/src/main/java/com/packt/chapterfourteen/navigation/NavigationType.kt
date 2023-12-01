package com.packt.chapterfourteen.navigation

sealed interface NavigationType {
    object BottomNavigation : NavigationType
    object NavigationDrawer : NavigationType
    object NavigationRail : NavigationType
}
