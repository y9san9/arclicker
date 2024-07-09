package me.y9san9.clicker.main.adapter.ui.types

import me.y9san9.clicker.main.ui.types.IncreaseAmount
import me.y9san9.clicker.main.domain.types.IncreaseAmount as DomainIncreaseAmount

fun IncreaseAmount.domain(): DomainIncreaseAmount {
    return DomainIncreaseAmount(int)
}
