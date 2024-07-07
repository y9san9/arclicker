package me.y9san9.clicker.main.di.ui.clicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import me.y9san9.clicker.main.domain.clicker.ClickerViewModel
import me.y9san9.clicker.main.ui.clicker.ClickerContent

@Composable
fun ClickerContent(viewModel: ClickerViewModel) {
    val amount by viewModel.amount.collectAsState()

    ClickerContent(
        amount = amount,
        onClick = viewModel::onClick
    )
}
