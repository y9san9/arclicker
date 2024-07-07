package me.y9san9.clicker.main.data

import android.content.SharedPreferences
import me.y9san9.clicker.main.ClicksAmount
import me.y9san9.clicker.main.IncreaseAmount

class MainSharedPreferencesWrapper(private val prefs: SharedPreferences) {
    fun saveClicksValue(amount: ClicksAmount) {
        prefs.edit().putInt("clicks.value", amount.int).apply()
    }
    fun loadClicksAmount(): ClicksAmount {
        val int = prefs.getInt("clicks.value", 0)
        return ClicksAmount(int)
    }

    fun saveIncreaseAmount(amount: IncreaseAmount) {
        prefs.edit().putInt("clicks.valuePerClick", amount.int).apply()
    }
    fun loadIncreaseAmount(): IncreaseAmount {
        val int = prefs.getInt("clicks.valuePerClick", 1)
        return IncreaseAmount(int)
    }
}
