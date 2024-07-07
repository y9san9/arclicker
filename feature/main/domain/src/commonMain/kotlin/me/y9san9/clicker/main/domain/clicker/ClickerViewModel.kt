package me.y9san9.clicker.main.domain.clicker

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.y9san9.clicker.main.ClicksAmount
import me.y9san9.clicker.main.IncreaseAmount

class ClickerViewModel(private val adapter: Adapter) {
    private val _amount: MutableStateFlow<ClicksAmount> = adapter.externalAmount
    val amount: StateFlow<ClicksAmount> = _amount

    fun onClick() {
        _amount.value += adapter.increaseAmount
    }

    interface Adapter {
        val scope: CoroutineScope
        val externalAmount: MutableStateFlow<ClicksAmount>
        val increaseAmount: IncreaseAmount
    }
}
