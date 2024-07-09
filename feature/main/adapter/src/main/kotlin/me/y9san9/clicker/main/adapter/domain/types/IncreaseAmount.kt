package me.y9san9.clicker.main.adapter.domain.types

import me.y9san9.clicker.main.domain.types.IncreaseAmount
import me.y9san9.clicker.main.data.types.IncreaseAmount as DataIncreaseAmount
import me.y9san9.clicker.main.ui.types.IncreaseAmount as UiIncreaseAmount

fun IncreaseAmount.data(): DataIncreaseAmount {
    return DataIncreaseAmount(int)
}

fun IncreaseAmount.ui(): UiIncreaseAmount {
    return UiIncreaseAmount(int)
}
