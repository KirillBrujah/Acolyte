package com.brujah.acolyte

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.ui.graphics.vector.ImageVector


interface AcolyteDestination {
    val icon: ImageVector?
    val route: String
}


object Spells : AcolyteDestination {
    override val icon = Icons.Filled.Create
    override val route = "spells"
}

object Potions : AcolyteDestination {
    override val icon = Icons.Filled.Create
    override val route = "potions"
}

object Favourites : AcolyteDestination {
    override val icon = Icons.Filled.Create
    override val route = "favourites"
}

val tabRowScreen = listOf(Spells, Potions, Favourites)