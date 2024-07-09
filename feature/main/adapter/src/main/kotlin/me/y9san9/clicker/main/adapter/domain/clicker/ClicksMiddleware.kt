package me.y9san9.clicker.main.adapter.domain.clicker

import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.adapter.data.types.domain
import me.y9san9.clicker.main.adapter.domain.types.data
import me.y9san9.clicker.main.data.MainSharedPreferencesWrapper
import me.y9san9.clicker.main.domain.clicker.ClicksMiddleware
import me.y9san9.clicker.main.domain.types.ClicksAmount

fun ClicksMiddleware(
    scope: CoroutineScope,
    mainPreferences: MainSharedPreferencesWrapper
): ClicksMiddleware {
    val adapter = object : ClicksMiddleware.Adapter {
        override val scope = scope
        override fun loadClicksAmount() = mainPreferences.loadClicksAmount().domain()
        override fun saveClicksAmount(value: ClicksAmount) = mainPreferences.saveClicksValue(value.data())
    }
    return ClicksMiddleware(adapter)
}
