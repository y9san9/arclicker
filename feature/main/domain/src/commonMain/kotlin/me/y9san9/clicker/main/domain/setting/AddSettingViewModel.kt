package me.y9san9.clicker.main.domain.setting

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import me.y9san9.clicker.main.ClickableButton
import me.y9san9.clicker.main.ClicksAmount
import me.y9san9.stdlib.validate.ValidatedValue

class AddSettingViewModel(private val env: Env) {
    val clicksAmount: MutableStateFlow<ValidatedValue<String, ClicksAmount>> =
        MutableStateFlow(ValidatedValue.Success("", ClicksAmount.Zero))

    private val _addButton: MutableStateFlow<ClickableButton> = MutableStateFlow(ClickableButton.Disabled)
    val addButton: StateFlow<ClickableButton> = _addButton

    init {
        clicksAmount.onEach { validated ->
            _addButton.value = when {
                validated !is ValidatedValue.Success -> ClickableButton.Disabled
                validated.value.int == 0 -> ClickableButton.Disabled
                else -> addButtonOf(validated.value)
            }
        }.launchIn(env.scope)
    }

    private fun addButtonOf(value: ClicksAmount): ClickableButton {
        return ClickableButton.Enabled(onClick = { env.addAmount(value) })
    }

    interface Env {
        val scope: CoroutineScope
        fun addAmount(value: ClicksAmount)
    }
}
