package me.y9san9.clicker.main.domain.setting

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.y9san9.clicker.main.ClickableButton
import me.y9san9.clicker.main.IncreaseAmount
import me.y9san9.stdlib.validate.ValidatedValue

class IncreaseSettingViewModel(private val adapter: Adapter) {
    val lastSaved = MutableStateFlow(adapter.loadInitialValue())

    val increaseAmount: MutableStateFlow<ValidatedValue<String, IncreaseAmount>>

    init {
        val initial = lastSaved.value
        val validated =  ValidatedValue.Success("${initial.int}", initial)
        increaseAmount = MutableStateFlow(validated)
    }

    private val _saveButton: MutableStateFlow<ClickableButton> = MutableStateFlow(ClickableButton.Disabled)
    val saveButton: StateFlow<ClickableButton> = _saveButton

    init {
        increaseAmount.onEach { validated ->
            _saveButton.value = when {
                validated !is ValidatedValue.Success -> ClickableButton.Disabled
                validated.value == lastSaved.value -> ClickableButton.Disabled
                else -> buttonOf(validated.value)
            }
        }.launchIn(adapter.scope)
    }

    private fun buttonOf(amount: IncreaseAmount): ClickableButton {
        return ClickableButton.Enabled {
            adapter.saveNewValue(amount)
            lastSaved.value = amount
        }
    }

    interface Adapter {
        val scope: CoroutineScope
        fun loadInitialValue(): IncreaseAmount
        fun saveNewValue(amount: IncreaseAmount)
    }
}
