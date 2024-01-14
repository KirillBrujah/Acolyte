package com.brujah.acolyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brujah.acolyte.ui.favourites.FavouritesScreen
import com.brujah.acolyte.ui.potions.PotionsScreen
import com.brujah.acolyte.ui.spells.SpellsScreen
import com.brujah.acolyte.ui.theme.AcolyteTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcolyteApp()
        }
    }
}

@Composable
fun AcolyteApp(
) {
    AcolyteTheme {
        val navController = rememberNavController()


        Scaffold(
            bottomBar = {
                AcolyteBottomNavBar(navController = navController)
            }
        ) { innerPadding ->
            AcolyteNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}


@Composable
fun AcolyteBottomNavBar(modifier: Modifier = Modifier, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestionation = navBackStackEntry?.destination
    NavigationBar {
        tabRowScreen.forEach { tab ->
            NavigationBarItem(
                selected = currentDestionation?.hierarchy?.any {it.route == tab.route} == true,
                onClick = {
                          navController.navigate(tab.route) {
                              popUpTo(navController.graph.findStartDestination().id) {
                                  saveState = true
                              }
                              launchSingleTop = true
                              restoreState = true
                          }
                },
                icon = {
                    Icon(imageVector = tab.icon!!, contentDescription = tab.route)
                },
                label = {
                    Text(stringResource(id = tab.labelId!!))
                })
        }
    }
}

@Composable
fun AcolyteNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController, startDestination = Spells.route,
        modifier = modifier,
    ) {
        composable(Spells.route) {
            SpellsScreen(navController = navController)
        }
        composable(Potions.route) {
            PotionsScreen()
        }
        composable(Favourites.route) {
            FavouritesScreen()
        }
    }
}