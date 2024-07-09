package me.y9san9.clicker.main.adapter.domain.clicker

import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.data.MainSharedPreferencesWrapper
import me.y9san9.clicker.main.adapter.data.types.domain
import me.y9san9.clicker.main.domain.clicker.ClickerViewModel
import me.y9san9.clicker.main.domain.clicker.ClicksMiddleware

fun ClickerViewModel(
    scope: CoroutineScope,
    clicksMiddleware: ClicksMiddleware,
    mainPreferences: MainSharedPreferencesWrapper
): ClickerViewModel {
    val adapter = object : ClickerViewModel.Adapter {
        override val scope = scope
        override val externalAmount = clicksMiddleware.state
        override val increaseAmount get() = mainPreferences.loadIncreaseAmount().domain()
    }
    return ClickerViewModel(adapter)
}
