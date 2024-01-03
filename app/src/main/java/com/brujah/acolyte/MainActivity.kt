package com.brujah.acolyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

        Scaffold { innerPadding ->
            AcolyteNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
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