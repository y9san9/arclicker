package me.y9san9.clicker.main.adapter.domain

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.adapter.domain.clicker.ClickerViewModel
import me.y9san9.clicker.main.adapter.domain.clicker.ClicksMiddleware
import me.y9san9.clicker.main.adapter.domain.setting.AddSettingViewModel
import me.y9san9.clicker.main.adapter.domain.setting.IncreaseSettingViewModel
import me.y9san9.clicker.main.data.MainSharedPreferencesWrapper
import me.y9san9.clicker.main.domain.MainComponent

fun MainComponent(applicationContext: Context, scope: CoroutineScope): MainComponent {
    val mainPreferences = MainSharedPreferencesWrapper(applicationContext)
    val clicksMiddleware = ClicksMiddleware(scope, mainPreferences)
    val clicker = ClickerViewModel(scope, clicksMiddleware, mainPreferences)
    val addSetting = AddSettingViewModel(scope, clicksMiddleware)
    val increaseSetting = IncreaseSettingViewModel(scope, mainPreferences)
    return MainComponent(clicker, addSetting, increaseSetting)
}
