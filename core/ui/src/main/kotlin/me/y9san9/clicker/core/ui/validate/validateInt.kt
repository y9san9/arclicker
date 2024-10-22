package me.y9san9.clicker.core.ui.validate

fun validateInt(value: String): ValidatedString<Int> {
    val intOrNull = value.toIntOrNull()
    return if (intOrNull == null) {
        ValidatedValue.Failure(value)
    } else {
        ValidatedValue.Success(value, intOrNull)
    }
}
