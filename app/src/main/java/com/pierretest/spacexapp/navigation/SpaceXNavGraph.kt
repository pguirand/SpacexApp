package com.pierretest.mygamestoreapp.ui.navigation.navgraph


import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.pierretest.spacexapp.navigation.AllDestinations
import com.pierretest.spacexapp.navigation.DestinationNames
import com.pierretest.spacexapp.ui.DetailLaunchScreen
import com.pierretest.spacexapp.ui.LaunchListScreen
import com.pierretest.spacexapp.ui.LaunchesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceXNavGraph(
    viewModel: LaunchesViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: DestinationNames.HOME
    val navigationActions = remember(navController) {
        AllDestinations(navController)
    }

    ModalNavigationDrawer(drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateToHome = { navigationActions.navigateToHome() },
            navigateToAbout = {navigationActions.navigateToAbout()},
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier= Modifier)
    }, drawerState = drawerState) {
        Scaffold(
            topBar = {
                if (currentRoute != "DetailLaunchScreen/{launchId}") {
                TopAppBar(title = {
                    val titleText = if (currentRoute == "DetailLaunchScreen/{launchId}") {
                        "Details"
                    } else {
                        currentRoute
                    }
                    Text(text = titleText)
                },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() }
                        }, content = {
                            Icon(
                                imageVector = Icons.Default.Menu, contentDescription = null
                            )
                        })
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer))
                } else {
                    TopAppBar(
                        title = {

                            Text(text = "Details")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        navigationIcon = {
                            IconButton(onClick = {
                                navController.navigateUp()
                            }, content = {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack, contentDescription = "Back"
                                )
                            })
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                    )
                }

            }, modifier = Modifier
        ) {
            NavHost(
                navController = navController,
                startDestination = DestinationNames.HOME,
                modifier = modifier.padding(it)
            ) {

                composable("DetailLaunchScreen/{launchId}") { backStackEntry ->
                    val launchId = backStackEntry.arguments?.getString("launchId")
                    val launch = viewModel.listSearchLaunches.value.firstOrNull { it.flightNumber.toString() == launchId }
                    if (launch != null) {
                        DetailLaunchScreen(launch)
                    }
                }
                composable(DestinationNames.HOME) {
                    LaunchListScreen(navController)
                }

                composable(DestinationNames.ABOUT) {
                    @Composable
                    fun helloWorld(){

                    }
                }

            }
        }
    }
}