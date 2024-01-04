package com.brujah.acolyte.ui.spells

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brujah.acolyte.data.Spell
import com.brujah.acolyte.data.SpellsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpellsViewModel @Inject constructor(
    private val spellsRepository: SpellsRepository
) : ViewModel() {

    val spells: List<Spell> = listOf()
//    val spells: List<Spell> = spellsRepository.spells

    // TODO: Spells list from API
    // TODO: Favorite spells


    // TODO: Add/Remove spell from Favorites



    private fun getSpells() {
        viewModelScope.launch {
            val listResult = spellsRepository.getSpells()
//            val result = SpellsApi.retrofitService.getSpell("d8233516-c8b0-4294-89b8-1e35eec4e820")

            Log.d("SpellsViewModel", listResult.toString())
//            Log.d("SpellsViewModel", result.toString())
        }
    }

    init {
        getSpells()
    }



    private val _searchState = MutableStateFlow("")
    val searchState: StateFlow<String> = _searchState.asStateFlow()

    fun search(query: String) {
        _searchState.value = query
    }
}