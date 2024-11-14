package com.example.first

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource

data class GameUiState(
    val user: Boolean = false,
    val ButtonColor1: Boolean = false,
    val ButtonColor2: Boolean = false,
    val ButtonColor3: Boolean = false,
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


