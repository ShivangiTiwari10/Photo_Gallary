package com.example.photo_gallery.ui.components


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photo_gallery.ui.theme.Purple40
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.photo_gallery.R


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

@Composable
fun PhotoComponent(
) {
    CaptureImage()
}


const val TAG = "Photoscreen"

@Composable
fun CaptureImage(
    painter: Painter = painterResource(id = R.drawable.camera),
    modifier: Modifier = Modifier.clickable(onClick = {
        // Action to perform
        Log .d(TAG, "icon Clicked")
    })
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = modifier.size(30.dp)
        )
    }
}

@Preview
@Composable
fun prev() {
    PhotoComponent()

}


