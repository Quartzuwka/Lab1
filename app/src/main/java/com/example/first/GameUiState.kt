package com.example.first

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource

data class GameUiState(


    val userScore: Int = 0,
    val computerScore: Int = 0,
    val isGameOver: Boolean = false,
    val userChoice1: Int = R.drawable.rock,
    val userChoice2: Int = R.drawable.paper,
    val userChoice3: Int = R.drawable.scissors,
    val computerChoice1: Int = R.drawable.rock,
    val computerChoice2: Int = R.drawable.paper,
    val computerChoice3: Int = R.drawable.scissors,
)


