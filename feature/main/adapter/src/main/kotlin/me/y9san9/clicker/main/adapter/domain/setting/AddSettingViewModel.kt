package me.y9san9.clicker.main.adapter.domain.setting

import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.domain.clicker.ClicksMiddleware
import me.y9san9.clicker.main.domain.setting.AddSettingViewModel
import me.y9san9.clicker.main.domain.types.ClicksAmount

fun AddSettingViewModel(scope: CoroutineScope, clicksMiddleware: ClicksMiddleware): AddSettingViewModel {
    val adapter = object : AddSettingViewModel.Adapter {
        override val scope = scope
        override fun addAmount(value: ClicksAmount) { clicksMiddleware.state.value += value }
    }
    return AddSettingViewModel(adapter)
}
