package com.pierretest.spacexapp.navigation

import androidx.navigation.NavController
import com.pierretest.spacexapp.navigation.DestinationNames.ABOUT
import com.pierretest.spacexapp.navigation.DestinationNames.HOME

object DestinationNames {
    const val HOME = "Home"
    const val ABOUT = "About"

}

class AllDestinations(private val navController: NavController) {

    fun navigateToHome() {
        navController.navigate(HOME) {
            popUpTo(HOME)
        }
    }

    fun navigateToAbout() {
        navController.navigate(ABOUT) {
            popUpTo(ABOUT)
        }
    }
}