package me.y9san9.clicker.main.di.ui.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import me.y9san9.clicker.main.domain.setting.AddSettingViewModel
import me.y9san9.clicker.main.ui.setting.AddSettingContent

@Composable
fun AddSettingContent(viewModel: AddSettingViewModel) {
    val clicksAmount by viewModel.clicksAmount.collectAsState()
    val add by viewModel.addButton.collectAsState()

    AddSettingContent(
        value = clicksAmount,
        onValueChange = { viewModel.clicksAmount.value = it },
        add = add
    )
}
