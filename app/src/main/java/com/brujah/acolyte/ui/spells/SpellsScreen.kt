package com.brujah.acolyte.ui.spells

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.brujah.acolyte.data.SpellsData
import com.brujah.acolyte.ui.base.SpellCard

@Preview
@Composable
fun SpellsScreen(
    modifier: Modifier = Modifier,
    viewModel: SpellsViewModel = viewModel()
) {
    val searchState by viewModel.searchState.collectAsState()
    val onSearch: (String) -> Unit = { value -> viewModel.search(value) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        ) {

        TextField(
            value = searchState,
            onValueChange = onSearch,
            modifier = Modifier.fillMaxWidth()
        )
        Text(searchState)

        Spacer(modifier = Modifier.size(15.dp))

        SpellsData.spells.forEach { spell ->
            SpellCard(spell = spell)
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}