package me.y9san9.clicker.main.di.domain.setting

import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.ClicksAmount
import me.y9san9.clicker.main.domain.clicker.ClicksMiddleware
import me.y9san9.clicker.main.domain.setting.AddSettingViewModel

fun AddSettingViewModel(
    scope: CoroutineScope,
    clicks: ClicksMiddleware
): AddSettingViewModel {
    val adapter = object : AddSettingViewModel.Adapter {
        override val scope = scope
        override fun addAmount(value: ClicksAmount) { clicks.state.value += value }
    }
    return AddSettingViewModel(adapter)
}
