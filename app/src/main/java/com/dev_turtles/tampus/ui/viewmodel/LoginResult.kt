package com.dev_turtles.tampus.ui.viewmodel

sealed class LoginResult {
    object Success : LoginResult()
    data class Error(val message: String) : LoginResult()
}