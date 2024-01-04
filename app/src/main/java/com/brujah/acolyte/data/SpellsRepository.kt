package com.brujah.acolyte.data

import com.brujah.acolyte.data.source.local.SpellsLocalDataSource
import com.brujah.acolyte.data.source.network.SpellsApiService
import javax.inject.Inject

class SpellsRepository @Inject constructor(
    private val spellsLocalDataSource: SpellsLocalDataSource,
    private val spellsApiService: SpellsApiService
) {
    suspend fun getSpells() : List<Spell> {
        return spellsApiService.getSpells()
    }

    // TODO: get Saved spells

    // TODO: Add/Remove spell from Favorites
}