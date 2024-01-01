package com.brujah.acolyte.ui.spells

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SpellsViewModel() : ViewModel() {

    // TODO: Spells list from API
    // TODO: Favorite spells


    // TODO: Add/Remove spell from Favorites

    private val _searchState = MutableStateFlow("")
    val searchState: StateFlow<String> = _searchState.asStateFlow()

    fun search(query: String) {
        _searchState.value = query
    }


}