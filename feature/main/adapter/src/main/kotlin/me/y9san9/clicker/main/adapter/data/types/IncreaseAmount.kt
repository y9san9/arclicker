package me.y9san9.clicker.main.adapter.data.types

import me.y9san9.clicker.main.data.types.IncreaseAmount
import me.y9san9.clicker.main.domain.types.IncreaseAmount as DomainIncreaseAmount

fun IncreaseAmount.domain(): DomainIncreaseAmount {
    return DomainIncreaseAmount(int)
}
