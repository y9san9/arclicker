package me.y9san9.clicker.main.adapter.data.types

import me.y9san9.clicker.main.data.types.ClicksAmount
import me.y9san9.clicker.main.domain.types.ClicksAmount as DomainClicksAmount

fun ClicksAmount.domain(): DomainClicksAmount {
    return DomainClicksAmount(int)
}
