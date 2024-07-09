package me.y9san9.clicker.core.adapter.ui.validate

import me.y9san9.clicker.core.ui.validate.ValidatedValue
import me.y9san9.clicker.core.ui.validate.map
import me.y9san9.clicker.core.domain.validate.ValidatedValue as DomainValidatedValue

fun <T, R> ValidatedValue<T, R>.domain(): DomainValidatedValue<T, R> = when (this) {
    is ValidatedValue.Failure -> DomainValidatedValue.Failure(input)
    is ValidatedValue.Success -> DomainValidatedValue.Success(input, value)
}

inline fun <T, R1, R2> ValidatedValue<T, R1>.domain(block: (R1) -> R2): DomainValidatedValue<T, R2> {
    return map(block).domain()
}

inline fun <T1, T2, R1, R2> ValidatedValue<T1, R1>.domain(input: (T1) -> T2, value: (R1) -> R2): DomainValidatedValue<T2, R2> = when (this) {
    is ValidatedValue.Failure -> DomainValidatedValue.Failure(input(this.input))
    is ValidatedValue.Success -> DomainValidatedValue.Success(input(this.input), value(this.value))
}
