package me.y9san9.clicker.main.ui.setting

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.y9san9.clicker.R
import me.y9san9.clicker.main.ClickableButton
import me.y9san9.clicker.main.ClicksAmount
import me.y9san9.stdlib.validate.ValidatedString
import me.y9san9.stdlib.validate.map
import me.y9san9.stdlib.validate.validateInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSettingContent(
    value: ValidatedString<ClicksAmount>,
    onValueChange: (ValidatedString<ClicksAmount>) -> Unit,
    add: ClickableButton
) {
    Row(Modifier.padding(horizontal = 20.dp)) {
        TextField(
            value = value.input,
            placeholder = { Text("0", Modifier.alpha(0.5f)) },
            onValueChange = { update ->
                val validated = validateInt(update).map(::ClicksAmount)
                onValueChange(validated)
            },
            modifier = Modifier.weight(1f),
            singleLine = true
        )
        Spacer(Modifier.width(20.dp))
        Crossfade(add is ClickableButton.Enabled) { enabled ->
            Button(
                enabled = enabled,
                onClick = {
                    if (add is ClickableButton.Enabled) {
                        add.onClick()
                    }
                }
            ) {
                Text(
                    text = stringResource(R.string.add),
                )
            }
        }
    }
}
