package com.brujah.acolyte.ui.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brujah.acolyte.data.Spell

@Preview
@Composable
fun SpellCard(
    spell: Spell = Spell("asd", "dfghjkl"),
    isFavorite: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp),
        ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            // TODO: Spell image
            Icon(
                Icons.Rounded.Create, contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.size(5.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    spell.name.repeat(10),
                    maxLines = 2,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    "TODO: Spell effect".repeat(10), maxLines = 2,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.size(5.dp))
            IconButton(
                onClick = {
                    TODO("Set favorite")
                },
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    if (isFavorite)
                        Icons.Rounded.Star
                    else
                        Icons.Outlined.Build,
                    contentDescription = null,
                )
            }

        }
    }

}