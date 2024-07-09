package me.y9san9.clicker.main.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import me.y9san9.clicker.main.data.types.ClicksAmount
import me.y9san9.clicker.main.data.types.IncreaseAmount

class MainSharedPreferencesWrapper(private val prefs: SharedPreferences) {
    constructor(context: Context) : this(context.getSharedPreferences("main", MODE_PRIVATE))

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
