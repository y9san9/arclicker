package me.y9san9.clicker.core.adapter.domain.validate

import me.y9san9.clicker.core.domain.validate.ValidatedValue
import me.y9san9.clicker.core.domain.validate.map
import me.y9san9.clicker.core.ui.validate.ValidatedValue as UiValidatedValue

fun <T, R> ValidatedValue<T, R>.ui(): UiValidatedValue<T, R> = when (this) {
    is ValidatedValue.Failure -> UiValidatedValue.Failure(input)
    is ValidatedValue.Success -> UiValidatedValue.Success(input, value)
}

inline fun <T, R1, R2> ValidatedValue<T, R1>.ui(block: (R1) -> R2): UiValidatedValue<T, R2> {
    return map(block).ui()
}

inline fun <T1, T2, R1, R2> ValidatedValue<T1, R1>.ui(input: (T1) -> T2, value: (R1) -> R2): UiValidatedValue<T2, R2> = when (this) {
    is ValidatedValue.Failure -> UiValidatedValue.Failure(input(this.input))
    is ValidatedValue.Success -> UiValidatedValue.Success(input(this.input), value(this.value))
}
