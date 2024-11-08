package com.example.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.first.ui.theme.FirstTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Game()
        }
    }
}

@Composable
fun Game() {
    Column(modifier = Modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier.weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = {}
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.rock),
                        contentDescription = "Камень"
                    )
                }
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = { }
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.scissors),
                        contentDescription = "Ножницы"
                    )
                }
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = { }
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.paper),
                        contentDescription = "Бумага"
                    )
                }
            }
            Box(modifier = Modifier.weight(1f).fillMaxWidth(),
                contentAlignment = Alignment.Center) {
                Text("1234")
            }
        }



        Column(
            modifier = Modifier.weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth(),
                contentAlignment = Alignment.Center) {
                Text("1234")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                OutlinedButton(
                    enabled = false,
                    modifier = Modifier.weight(1f),
                    onClick = {}
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.rock),
                        contentDescription = "Камень"
                    )
                }
                OutlinedButton(
                    enabled = false,
                    modifier = Modifier.weight(1f),
                    onClick = { }
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.scissors),
                        contentDescription = "Ножницы"
                    )
                }
                OutlinedButton(
                    enabled = false,
                    modifier = Modifier.weight(1f),
                    onClick = { }
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.paper),
                        contentDescription = "Бумага"
                    )
                }
            }
            Box(modifier = Modifier.weight(1f))
        }
    }
}
