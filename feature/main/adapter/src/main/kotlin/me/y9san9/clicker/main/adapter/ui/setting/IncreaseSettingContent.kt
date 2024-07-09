package me.y9san9.clicker.main.adapter.ui.setting

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import me.y9san9.clicker.core.adapter.domain.button.ui
import me.y9san9.clicker.core.adapter.domain.validate.ui
import me.y9san9.clicker.core.adapter.ui.validate.domain
import me.y9san9.clicker.main.adapter.data.types.domain
import me.y9san9.clicker.main.adapter.domain.types.ui
import me.y9san9.clicker.main.adapter.ui.types.domain
import me.y9san9.clicker.main.domain.setting.IncreaseSettingViewModel
import me.y9san9.clicker.main.ui.setting.IncreaseSettingContent
import me.y9san9.clicker.main.ui.types.IncreaseAmount
import me.y9san9.clicker.main.domain.types.IncreaseAmount as DomainIncreaseAmount

@Composable
fun IncreaseSettingContent(viewModel: IncreaseSettingViewModel) {
    val lastSaved by viewModel.lastSaved.collectAsState()
    val increaseAmount by viewModel.increaseAmount.collectAsState()
    val save by viewModel.save.collectAsState()

    IncreaseSettingContent(
        lastSaved = lastSaved.ui(),
        value = increaseAmount.ui(DomainIncreaseAmount::ui),
        onValueChange = { value ->
            viewModel.increaseAmount.value = value.domain(IncreaseAmount::domain)
        },
        save = save.ui()
    )
}
