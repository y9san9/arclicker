package me.y9san9.clicker.main.domain.clicker

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.y9san9.clicker.main.domain.types.ClicksAmount

class ClicksMiddleware(adapter: Adapter) {
    val state: MutableStateFlow<ClicksAmount> = MutableStateFlow(adapter.loadClicksAmount())

    init {
        state.onEach(adapter::saveClicksAmount).launchIn(adapter.scope)
    }

    interface Adapter {
        val scope: CoroutineScope
        fun loadClicksAmount(): ClicksAmount
        fun saveClicksAmount(value: ClicksAmount)
    }
}
