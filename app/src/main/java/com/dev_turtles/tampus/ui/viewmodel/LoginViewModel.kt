package com.dev_turtles.tampus.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev_turtles.tampus.data.model.LoginRequest
import com.dev_turtles.tampus.data.model.TokenResponse
import com.dev_turtles.tampus.data.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> get() = _loginResult

    fun authenticate(email: String, password: String) {
        val credentials = LoginRequest(email, password)
        userRepository.authenticate(credentials).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                if (response.isSuccessful) {
                    val token = response.body()?.token
                    if (!token.isNullOrBlank()) {
                        // Manejar el token (por ejemplo, almacenarlo y navegar a la siguiente pantalla)
                        _loginResult.value = LoginResult.Success
                    } else {
                        _loginResult.value = LoginResult.Error("Token vacío")
                    }
                } else {
                    _loginResult.value = LoginResult.Error("Credenciales inválidas")
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                _loginResult.value = LoginResult.Error("Error en la llamada a la API")
            }
        })
    }
}

