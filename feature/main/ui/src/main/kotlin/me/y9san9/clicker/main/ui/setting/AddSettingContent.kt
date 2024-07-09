package me.y9san9.clicker.main.ui.setting

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.y9san9.clicker.R
import me.y9san9.clicker.core.ui.button.ClickableButton
import me.y9san9.clicker.core.ui.validate.ValidatedString
import me.y9san9.clicker.core.ui.validate.map
import me.y9san9.clicker.core.ui.validate.validateInt
import me.y9san9.clicker.main.ui.types.ClicksAmount

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSettingContent(
    value: ValidatedString<ClicksAmount>,
    onValueChange: (ValidatedString<ClicksAmount>) -> Unit,
    add: ClickableButton
) {
    Column(Modifier.padding(horizontal = 20.dp)) {
        TextField(
            value = value.input,
            placeholder = { Text("0", Modifier.alpha(0.5f)) },
            onValueChange = { update ->
                val validated = validateInt(update).map(::ClicksAmount)
                onValueChange(validated)
            },
            label = { Text(stringResource(R.string.enter_amount_to_add)) },
            modifier = Modifier.fillMaxWidth(1f),
            singleLine = true
        )
        Spacer(Modifier.height(5.dp))
        Crossfade(add is ClickableButton.Enabled, Modifier.align(Alignment.CenterHorizontally)) { enabled ->
            Button(
                enabled = enabled,
                onClick = {
                    if (add is ClickableButton.Enabled) {
                        add.onClick()
                    }
                },
                contentPadding = PaddingValues(horizontal = 75.dp)
            ) {
                Text(
                    text = stringResource(R.string.add),
                )
            }
        }
    }
}
