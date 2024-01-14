package com.brujah.acolyte

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.ui.graphics.vector.ImageVector


interface AcolyteDestination {
    val icon: ImageVector?
    val route: String
    val labelId: Int?
}


object Spells : AcolyteDestination {
    override val icon = Icons.Filled.Create
    override val route = "spells"
    override val labelId = R.string.spells
}

object Potions : AcolyteDestination {
    override val icon = Icons.Filled.Create
    override val route = "potions"
    override val labelId = R.string.potions
    
}

object Favourites : AcolyteDestination {
    override val icon = Icons.Filled.Create
    override val route = "favourites"
    override val labelId = R.string.favourites
    
}

val tabRowScreen = listOf(Spells, Potions, Favourites)