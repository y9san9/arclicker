package me.y9san9.clicker.main.adapter.domain.types

import me.y9san9.clicker.main.domain.types.ClicksAmount
import me.y9san9.clicker.main.data.types.ClicksAmount as DataClicksAmount
import me.y9san9.clicker.main.ui.types.ClicksAmount as UiClicksAmount

fun ClicksAmount.data(): DataClicksAmount {
    return DataClicksAmount(int)
}

fun ClicksAmount.ui(): UiClicksAmount {
    return UiClicksAmount(int)
}
