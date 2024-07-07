package me.y9san9.clicker.main.di.domain.clicker

import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.IncreaseAmount
import me.y9san9.clicker.main.domain.clicker.ClicksMiddleware
import me.y9san9.clicker.main.data.MainSharedPreferencesWrapper
import me.y9san9.clicker.main.domain.clicker.ClickerViewModel

fun ClickerViewModel(
    scope: CoroutineScope,
    clicks: ClicksMiddleware,
    mainPreferences: MainSharedPreferencesWrapper
): ClickerViewModel {
    val adapter = object : ClickerViewModel.Adapter {
        override val scope = scope
        override val externalAmount = clicks.state
        override val increaseAmount get() = mainPreferences.loadIncreaseAmount()
    }
    return ClickerViewModel(adapter)
}
