package me.y9san9.clicker.main.domain.setting

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import me.y9san9.clicker.core.domain.button.ClickableButton
import me.y9san9.clicker.core.domain.validate.ValidatedValue
import me.y9san9.clicker.main.domain.types.ClicksAmount

class AddSettingViewModel(private val adapter: Adapter) {
    private val zero = ValidatedValue.Success("", ClicksAmount.Zero)
    val clicksAmount: MutableStateFlow<ValidatedValue<String, ClicksAmount>> = MutableStateFlow(zero)

    private val _add: MutableStateFlow<ClickableButton> = MutableStateFlow(ClickableButton.Disabled)
    val add: StateFlow<ClickableButton> = _add

    init {
        clicksAmount.onEach { validated ->
            _add.value = when {
                validated !is ValidatedValue.Success -> ClickableButton.Disabled
                validated.value.int == 0 -> ClickableButton.Disabled
                else -> addButtonOf(validated.value)
            }
        }.launchIn(adapter.scope)
    }

    private fun addButtonOf(value: ClicksAmount): ClickableButton {
        return ClickableButton.Enabled {
            adapter.addAmount(value)
            clicksAmount.value = zero
        }
    }

    interface Adapter {
        val scope: CoroutineScope
        fun addAmount(value: ClicksAmount)
    }
}
