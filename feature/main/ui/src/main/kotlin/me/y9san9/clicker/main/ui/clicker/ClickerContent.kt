package me.y9san9.clicker.main.ui.clicker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.y9san9.clicker.main.ClicksAmount

@Composable
fun ClickerContent(
    amount: ClicksAmount,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().clickable(onClick = onClick),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${amount.int}")
    }
}
