package com.brujah.acolyte.ui.spells

import androidx.lifecycle.ViewModel
import com.brujah.acolyte.data.Spell
import com.brujah.acolyte.data.SpellsLocalDataSource
import com.brujah.acolyte.data.SpellsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class SpellsViewModel @Inject constructor(
    private val spellsRepository: SpellsRepository
) : ViewModel() {

//    val spells: List<Spell> = listOf()
    val spells: List<Spell> = spellsRepository.spells

    // TODO: Spells list from API
    // TODO: Favorite spells


    // TODO: Add/Remove spell from Favorites

    private val _searchState = MutableStateFlow("")
    val searchState: StateFlow<String> = _searchState.asStateFlow()

    fun search(query: String) {
        _searchState.value = query
    }
}