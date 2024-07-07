package me.y9san9.clicker.main

sealed interface ClickableButton {
    data object Disabled : ClickableButton
    data class Enabled(val onClick: () -> Unit) : ClickableButton
}
