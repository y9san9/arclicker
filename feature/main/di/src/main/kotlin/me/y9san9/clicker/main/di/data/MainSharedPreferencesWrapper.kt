package me.y9san9.clicker.main.di.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import me.y9san9.clicker.main.data.MainSharedPreferencesWrapper

fun MainSharedPreferencesWrapper(context: Context): MainSharedPreferencesWrapper {
    val prefs = context.getSharedPreferences("main", MODE_PRIVATE)
    return MainSharedPreferencesWrapper(prefs)
}

// Any
// Nothing
