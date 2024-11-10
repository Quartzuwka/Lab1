package com.example.first


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.Int
import kotlin.properties.Delegates
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {


    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    val possibilities = listOf<Int>(uiState.value.computerChoice1,uiState.value.computerChoice2,uiState.value.computerChoice3)


    var _userScore by mutableStateOf(0)
        private set

    var userChoice by mutableStateOf("")
        private set

    var computerChoice by mutableStateOf("")
        private set

    init {
        resetGame()
    }

    fun resetGame() {
        _uiState.value = GameUiState(userScore = 0,
        computerScore= 0,
        isGameOver = false,
        userChoice1 = R.drawable.rock,
        userChoice2 = R.drawable.paper,
        userChoice3 = R.drawable.scissors,
        computerChoice1 = R.drawable.rock,
        computerChoice2 = R.drawable.paper,
        computerChoice3 = R.drawable.scissors,
        )
    }

    fun onChoose(chosen: Int) {

        if( chosen.toString() == onComputerChoose()) {

            val updatedScore = _uiState.value.userScore.plus(15)

            val user = true
            updateGameScore(updatedScore, user)
        } else {
            val user = false
            val updatedScore = _uiState.value.computerScore.plus(15)
            updateGameScore(updatedScore, user)
        }

    }

    fun updateGameScore(updatedScore: Int, user: Boolean) {
        if (user) {
            _uiState.update { currentState ->
                currentState.copy(
                    userScore = updatedScore,

                )
            }
        }
        else {
            _uiState.update { currentState ->
                currentState.copy(
                    computerScore = updatedScore,
                    )
            }
        }
    }

    fun onComputerChoose():String {
        computerChoice = possibilities.random().toString()
        return computerChoice
    }
}