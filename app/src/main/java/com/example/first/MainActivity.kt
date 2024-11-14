package com.example.first

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first.ui.theme.FirstTheme
import kotlin.Int

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
fun Game(
    mainViewModel: MainViewModel = viewModel()
) {
    val mainUiState by mainViewModel.uiState.collectAsState()
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val color = if (isPressed) mainViewModel.changeButtonColor() else Color.White

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
                    onClick = {mainViewModel.onChoose(mainUiState.userChoice1)}
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(mainUiState.userChoice1),
                        contentDescription = "Камень"
                    )
                }
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = {mainViewModel.onChoose(mainUiState.userChoice2)}
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(mainUiState.userChoice2),
                        contentDescription = "Ножницы"
                    )
                }
                OutlinedButton(
                    interactionSource = interactionSource,
                    colors= ButtonDefaults.buttonColors(color),
                    modifier = Modifier.weight(1f),
                    onClick = {mainViewModel.onChoose(mainUiState.userChoice3)}
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(mainUiState.userChoice3),
                        contentDescription = "Бумага"
                    )
                }
            }
            Box(modifier = Modifier.weight(1f).fillMaxWidth(),
                contentAlignment = Alignment.Center) {
                Text(text = stringResource(R.string.userScore, mainUiState.userScore))

            }
        }



        Column(
            modifier = Modifier.weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth(),
                contentAlignment = Alignment.Center) {
                Text(text = stringResource(R.string.computerScore, mainUiState.computerScore))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                OutlinedButton(
                    colors = if (mainUiState.ButtonColor1) ButtonDefaults.buttonColors(
                        disabledContainerColor = Color.Green
                    ) else ButtonDefaults.buttonColors(
                        disabledContainerColor = Color.White
                    ),
                    enabled = false,
                    modifier = Modifier.weight(1f),
                    onClick = {}
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(mainUiState.computerChoice1),
                        contentDescription = "Камень"
                    )
                }
                OutlinedButton(
                    colors = if (mainUiState.ButtonColor2) ButtonDefaults.buttonColors(
                        disabledContainerColor = Color.Green
                    ) else ButtonDefaults.buttonColors(
                        disabledContainerColor = Color.White
                    ),
                    enabled = false,
                    modifier = Modifier.weight(1f),
                    onClick = { }
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(mainUiState.computerChoice2),
                        contentDescription = "Ножницы"
                    )
                }
                OutlinedButton(
                    colors = if (mainUiState.ButtonColor3) ButtonDefaults.buttonColors(
                        disabledContainerColor = Color.Green
                    ) else ButtonDefaults.buttonColors(
                        disabledContainerColor = Color.White
                    ),
                    enabled = false,
                    modifier = Modifier.weight(1f),
                    onClick = { }
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(mainUiState.computerChoice3),
                        contentDescription = "Бумага"
                    )
                }
            }
            Box(modifier = Modifier.weight(1f))
        }
    }
}
