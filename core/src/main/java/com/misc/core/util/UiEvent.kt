package com.misc.core.util

sealed class UiEvent {
    object Success : UiEvent()
    object NavigateUp : UiEvent()
    object ShowSnackBar : UiEvent()
}