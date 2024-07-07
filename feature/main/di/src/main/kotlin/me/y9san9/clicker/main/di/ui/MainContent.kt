package me.y9san9.clicker.main.di.ui

import androidx.compose.runtime.Composable
import me.y9san9.clicker.main.di.domain.mainComponent
import me.y9san9.clicker.main.di.ui.clicker.ClickerContent
import me.y9san9.clicker.main.di.ui.settings.AddSettingContent
import me.y9san9.clicker.main.di.ui.settings.IncreaseSettingContent
import me.y9san9.clicker.main.ui.MainContent

@Composable
fun MainContent() {
    val component = mainComponent()

    MainContent(
        clicker = { ClickerContent(component.clicker) },
        addSetting = { AddSettingContent(component.addSetting) },
        increase = { IncreaseSettingContent(component.increaseSetting) }
    )
}
