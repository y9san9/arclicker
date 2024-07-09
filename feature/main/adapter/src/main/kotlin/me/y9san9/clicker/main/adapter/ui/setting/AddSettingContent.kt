package me.y9san9.clicker.main.adapter.ui.setting

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import me.y9san9.clicker.core.adapter.domain.button.ui
import me.y9san9.clicker.core.adapter.domain.validate.ui
import me.y9san9.clicker.core.adapter.ui.validate.domain
import me.y9san9.clicker.main.adapter.domain.types.ui
import me.y9san9.clicker.main.adapter.ui.types.domain
import me.y9san9.clicker.main.domain.setting.AddSettingViewModel
import me.y9san9.clicker.main.ui.setting.AddSettingContent
import me.y9san9.clicker.main.ui.types.ClicksAmount
import me.y9san9.clicker.main.domain.types.ClicksAmount as DomainClicksAmount

@Composable
fun AddSettingContent(viewModel: AddSettingViewModel) {
    val value by viewModel.clicksAmount.collectAsState()
    val add by viewModel.add.collectAsState()

    AddSettingContent(
        value = value.ui(DomainClicksAmount::ui),
        onValueChange = { update ->
            viewModel.clicksAmount.value = update.domain(ClicksAmount::domain)
        },
        add = add.ui()
    )
}
