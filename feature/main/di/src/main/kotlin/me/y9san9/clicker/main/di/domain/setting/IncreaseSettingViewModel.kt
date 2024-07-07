package me.y9san9.clicker.main.di.domain.setting

import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.IncreaseAmount
import me.y9san9.clicker.main.data.MainSharedPreferencesWrapper
import me.y9san9.clicker.main.domain.setting.IncreaseSettingViewModel

fun IncreaseSettingViewModel(
    scope: CoroutineScope,
    mainPreferences: MainSharedPreferencesWrapper,
): IncreaseSettingViewModel {
    val adapter = object : IncreaseSettingViewModel.Adapter {
        override val scope = scope
        override fun loadInitialValue(): IncreaseAmount = mainPreferences.loadIncreaseAmount()
        override fun saveNewValue(amount: IncreaseAmount) = mainPreferences.saveIncreaseAmount(amount)
    }
    return IncreaseSettingViewModel(adapter)
}
