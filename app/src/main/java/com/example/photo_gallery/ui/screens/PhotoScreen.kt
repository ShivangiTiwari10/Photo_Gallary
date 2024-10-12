
package com.example.photo_gallery.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.photo_gallery.ui.components.NormalTextComponent
import com.example.photo_gallery.ui.components.PhotoComponent


@Composable
fun PhotoScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,

        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            NormalTextComponent(textValue = "ABCD")
            PhotoComponent()

        }
    }
}

@Preview
@Composable
fun prev() {
    PhotoScreen()
}