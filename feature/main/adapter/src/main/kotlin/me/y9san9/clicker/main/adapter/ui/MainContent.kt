package me.y9san9.clicker.main.adapter.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import me.y9san9.clicker.core.adapter.ui.viewmodel.viewModel
import me.y9san9.clicker.main.adapter.domain.MainComponent
import me.y9san9.clicker.main.adapter.ui.clicker.ClickerContent
import me.y9san9.clicker.main.adapter.ui.setting.AddSettingContent
import me.y9san9.clicker.main.adapter.ui.setting.IncreaseSettingContent
import me.y9san9.clicker.main.ui.MainContent

@Composable
fun MainContent() {
    val applicationContext = LocalContext.current.applicationContext
    val mainComponent = viewModel { scope -> MainComponent(applicationContext, scope) }

    MainContent(
        clicker = { ClickerContent(mainComponent.clicker) },
        addSetting = { AddSettingContent(mainComponent.addSetting) },
        increaseSetting = { IncreaseSettingContent(mainComponent.increaseSetting) }
    )
}
