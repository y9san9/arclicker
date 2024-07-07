package me.y9san9.clicker.main.di.domain.clicker

import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.ClicksAmount
import me.y9san9.clicker.main.domain.clicker.ClicksMiddleware
import me.y9san9.clicker.main.data.MainSharedPreferencesWrapper

fun ClicksMiddleware(
    scope: CoroutineScope,
    mainPreferences: MainSharedPreferencesWrapper
): ClicksMiddleware {
    val env = object : ClicksMiddleware.Env {
        override val scope = scope
        override fun loadClicksAmount(): ClicksAmount = mainPreferences.loadClicksAmount()
        override fun saveClicksAmount(value: ClicksAmount) { mainPreferences.saveClicksValue(value) }
    }
    return ClicksMiddleware(env)
}
