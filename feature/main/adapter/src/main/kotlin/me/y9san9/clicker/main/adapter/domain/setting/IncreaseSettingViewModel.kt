package me.y9san9.clicker.main.adapter.domain.setting

import kotlinx.coroutines.CoroutineScope
import me.y9san9.clicker.main.data.MainSharedPreferencesWrapper
import me.y9san9.clicker.main.adapter.data.types.domain
import me.y9san9.clicker.main.adapter.domain.types.data
import me.y9san9.clicker.main.domain.setting.IncreaseSettingViewModel
import me.y9san9.clicker.main.domain.types.IncreaseAmount

fun IncreaseSettingViewModel(
    scope: CoroutineScope,
    mainPreferences: MainSharedPreferencesWrapper
): IncreaseSettingViewModel {
    val adapter = object : IncreaseSettingViewModel.Adapter {
        override val scope = scope
        override fun loadInitialValue() = mainPreferences.loadIncreaseAmount().domain()
        override fun saveNewValue(amount: IncreaseAmount) = mainPreferences.saveIncreaseAmount(amount.data())
    }
    return IncreaseSettingViewModel(adapter)
}
