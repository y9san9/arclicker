package me.y9san9.clicker.main.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
inline fun MainContent(
    clicker: @Composable () -> Unit,
    addSetting: @Composable () -> Unit,
    increaseSetting: @Composable () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            clicker()
        }
        addSetting()
        Spacer(Modifier.height(20.dp))
        increaseSetting()
        Spacer(Modifier.height(40.dp))
    }
}
