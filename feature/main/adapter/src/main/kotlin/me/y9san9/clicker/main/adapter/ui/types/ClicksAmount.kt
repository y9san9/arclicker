package me.y9san9.clicker.main.adapter.ui.types

import me.y9san9.clicker.main.ui.types.ClicksAmount
import me.y9san9.clicker.main.domain.types.ClicksAmount as DomainClicksAmount

fun ClicksAmount.domain(): DomainClicksAmount {
    return DomainClicksAmount(int)
}
