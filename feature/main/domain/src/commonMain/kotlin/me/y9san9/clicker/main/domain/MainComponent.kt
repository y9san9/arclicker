package me.y9san9.clicker.main.domain

import me.y9san9.clicker.main.domain.clicker.ClickerViewModel
import me.y9san9.clicker.main.domain.setting.AddSettingViewModel
import me.y9san9.clicker.main.domain.setting.IncreaseSettingViewModel

class MainComponent(
    val clicker: ClickerViewModel,
    val addSetting: AddSettingViewModel,
    val increaseSetting: IncreaseSettingViewModel
)
