package me.y9san9.clicker.core.ui.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope

private class ViewModelImpl<T> : ViewModel() {
    var underlying: T? = null
}

@Composable
fun <T> viewModel(factory: (CoroutineScope) -> T): T {
    val viewModel = viewModel {
        val impl = ViewModelImpl<T>()
        impl.underlying = factory(impl.viewModelScope)
        impl
    }
    @Suppress("UNCHECKED_CAST")
    return viewModel.underlying as T
}
