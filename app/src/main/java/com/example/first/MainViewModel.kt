package com.example.first



import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.Int
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {


    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    val possibilities = listOf<Int>(uiState.value.computerChoice1,uiState.value.computerChoice2,uiState.value.computerChoice3)

    var inputValue: MutableState<Int> = mutableStateOf(0)
        private set


    private val _textState = mutableStateOf("")
    val textState: State<String> = _textState

    fun updateNumber(input: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                scoreValue = input
            )
        }
        inputValue.value = input
    }

//    var _userScore by mutableStateOf(0)
//        private set
//
//    var userChoice by mutableStateOf("")
//        private set

    var computerChoice by mutableStateOf(0)
        private set

//    var buttonColorOnChange: MutableLiveData<Color> = MutableLiveData(Color(0xFF4CAF50))

    init {
        resetGame()
    }

    fun resetGame() {
        _uiState.value = GameUiState(
        userScore = 0,
        computerScore= 0,
        isGameOver = false,
        userChoice1 = R.drawable.rock,
        userChoice2 = R.drawable.paper,
        userChoice3 = R.drawable.scissors,
        computerChoice1 = R.drawable.rock,
        computerChoice2 = R.drawable.paper,
        computerChoice3 = R.drawable.scissors,
        scoreValue = inputValue.value
        )
    }


    suspend fun ChangeColor(x: Int) {
        when (x) {
            R.drawable.rock -> {
                _uiState.value = _uiState.value.copy(ButtonColor1 = true)
                delay(1000)
                _uiState.value = _uiState.value.copy(ButtonColor1 = false)
            }
            R.drawable.paper -> {
                _uiState.value = _uiState.value.copy(ButtonColor2 = true)
                delay(1000)
                _uiState.value = _uiState.value.copy(ButtonColor2 = false)
            }
            R.drawable.scissors -> {
                _uiState.value = _uiState.value.copy(ButtonColor3 = true)
                delay(1000)
                _uiState.value = _uiState.value.copy(ButtonColor3 = false)
            }
        }
    }


    fun onChoose(chosen: Int) {


        val onComputerChoose = onComputerChoose()



        if( chosen == onComputerChoose) {

            val updatedScore = _uiState.value.userScore.plus(0)

            val user = true
            updateGameScore(updatedScore, user)

        } else {

            if ((chosen == R.drawable.rock) and (onComputerChoose == R.drawable.scissors)) {
                val updatedScore = _uiState.value.userScore.plus(_uiState.value.scoreValue)

                val user = true
                updateGameScore(updatedScore, user)
            }
            else if ((chosen == R.drawable.paper) and (onComputerChoose == R.drawable.rock)) {
                val updatedScore = _uiState.value.userScore.plus(_uiState.value.scoreValue)

                val user = true
                updateGameScore(updatedScore, user)
            }
            else if ((chosen == R.drawable.scissors) and (onComputerChoose == R.drawable.paper)) {
                val updatedScore = _uiState.value.userScore.plus(_uiState.value.scoreValue)

                val user = true
                updateGameScore(updatedScore, user)
            } else {
                val user = false
                val updatedScore = _uiState.value.computerScore.plus(_uiState.value.scoreValue)
                updateGameScore(updatedScore, user)
            }


        }

        val coroutineScope = viewModelScope
        coroutineScope.launch {

            ChangeColor(onComputerChoose)

        }
        if ((_uiState.value.userScore>=100) or (_uiState.value.computerScore>=100)) {
            if (_uiState.value.userScore>=100) {
                _uiState.update { currentState ->
                    currentState.copy(
                        isGameOver = true,
                        user = true
                    )
                }
            }
            if (_uiState.value.computerScore>=100) {
                _uiState.update { currentState ->
                    currentState.copy(
                        isGameOver = true,
                        user = false
                    )
                }
            }
        }
    }

      fun changeButtonColor(): Color {
          return Color.Green
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

    fun onComputerChoose():Int {
        computerChoice = possibilities.random()

        return computerChoice
    }

}
