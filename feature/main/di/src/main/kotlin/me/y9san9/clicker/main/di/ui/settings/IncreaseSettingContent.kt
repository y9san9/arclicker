package me.y9san9.clicker.main.di.ui.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import me.y9san9.clicker.main.domain.setting.IncreaseSettingViewModel
import me.y9san9.clicker.main.ui.setting.IncreaseSettingContent

@Composable
fun IncreaseSettingContent(viewModel: IncreaseSettingViewModel) {
    val clicksAmount by viewModel.increaseAmount.collectAsState()
    val lastSaved by viewModel.lastSaved.collectAsState()
    val save by viewModel.saveButton.collectAsState()

    IncreaseSettingContent(
        value = clicksAmount,
        onValueChange = { viewModel.increaseAmount.value = it },
        save = save,
        lastSaved = lastSaved
    )
}
