package com.brujah.acolyte.data

import javax.inject.Inject

class SpellsRepository @Inject constructor(
    private val spellsLocalDataSource: SpellsLocalDataSource
) {
    val spells: List<Spell> = spellsLocalDataSource.spells

    // TODO: Get filtered spells
}