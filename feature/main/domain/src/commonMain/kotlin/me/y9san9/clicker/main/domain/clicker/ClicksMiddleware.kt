package me.y9san9.clicker.main.domain.clicker

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.y9san9.clicker.main.ClicksAmount

class ClicksMiddleware(env: Env) {
    val state: MutableStateFlow<ClicksAmount> = MutableStateFlow(env.loadClicksAmount())

    init {
        state.onEach(env::saveClicksAmount).launchIn(env.scope)
    }

    interface Env {
        val scope: CoroutineScope
        fun loadClicksAmount(): ClicksAmount
        fun saveClicksAmount(value: ClicksAmount)
    }
}
