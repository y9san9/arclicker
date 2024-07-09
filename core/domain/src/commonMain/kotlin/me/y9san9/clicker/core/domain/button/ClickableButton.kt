package me.y9san9.clicker.core.domain.button

sealed interface ClickableButton {
    data object Disabled : ClickableButton
    data class Enabled(val onClick: () -> Unit) : ClickableButton
}
