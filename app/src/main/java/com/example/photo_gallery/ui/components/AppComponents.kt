package com.example.photo_gallery.ui.components



import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photo_gallery.ui.theme.Purple40
import androidx.compose.ui.Modifier


@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight(), text = textValue,
        style = TextStyle(
            color = Purple40,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace
        )
    )
}



