package me.y9san9.clicker.core.domain.validate

sealed interface ValidatedValue<out I, out V> {
    val input: I
    data class Failure<out I>(override val input: I) : ValidatedValue<I, Nothing>
    data class Success<out I, out V>(override val input: I, val value: V) : ValidatedValue<I, V>
}

inline fun <I, T, R> ValidatedValue<I, T>.map(block: (T) -> R): ValidatedValue<I, R> {
    return when (this) {
        is ValidatedValue.Failure -> ValidatedValue.Failure(input)
        is ValidatedValue.Success -> ValidatedValue.Success(input, block(value))
    }
}
