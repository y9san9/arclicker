package me.y9san9.clicker.main.ui.setting

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.y9san9.clicker.R
import me.y9san9.clicker.main.ClickableButton
import me.y9san9.clicker.main.ClicksAmount
import me.y9san9.clicker.main.IncreaseAmount
import me.y9san9.stdlib.validate.ValidatedString
import me.y9san9.stdlib.validate.ValidatedValue
import me.y9san9.stdlib.validate.map
import me.y9san9.stdlib.validate.validateInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncreaseSettingContent(
    lastSaved: IncreaseAmount,
    value: ValidatedString<IncreaseAmount>,
    onValueChange: (ValidatedString<IncreaseAmount>) -> Unit,
    save: ClickableButton
) {
    Column(Modifier.padding(horizontal = 20.dp)) {
        TextField(
            value = value.input,
            onValueChange = { value ->
                val validated = validateInt(value).map(::IncreaseAmount)
                onValueChange(validated)
            },
            placeholder = { Text("${lastSaved.int}", Modifier.alpha(0.5f)) },
            label = { Text(stringResource(R.string.enter_amount_per_click)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(Modifier.height(5.dp))
        Crossfade(save is ClickableButton.Enabled, Modifier.align(Alignment.CenterHorizontally)) { enabled ->
            Button(
                enabled = enabled,
                onClick = {
                    if (save is ClickableButton.Enabled) {
                        save.onClick()
                    }
                },
                contentPadding = PaddingValues(horizontal = 75.dp)
            ) {
                Text(
                    text = stringResource(R.string.save)
                )
            }
        }
    }
}
