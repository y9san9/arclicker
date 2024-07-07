package me.y9san9.clicker.main.di.domain

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import me.y9san9.clicker.core.ui.viewmodel.viewModel
import me.y9san9.clicker.main.di.data.MainSharedPreferencesWrapper
import me.y9san9.clicker.main.di.domain.clicker.ClickerViewModel
import me.y9san9.clicker.main.di.domain.clicker.ClicksMiddleware
import me.y9san9.clicker.main.di.domain.setting.AddSettingViewModel
import me.y9san9.clicker.main.di.domain.setting.IncreaseSettingViewModel
import me.y9san9.clicker.main.domain.MainComponent

@Composable
fun mainComponent(): MainComponent {
    val context = LocalContext.current

    return viewModel { scope ->
        val mainPreferences = MainSharedPreferencesWrapper(context)
        val clicks = ClicksMiddleware(scope, mainPreferences)

        val clicker = ClickerViewModel(scope, clicks, mainPreferences)
        val addSetting = AddSettingViewModel(scope, clicks)
        val increaseSetting = IncreaseSettingViewModel(scope, mainPreferences)

        MainComponent(clicker, addSetting, increaseSetting)
    }
}
