package com.dev_turtles.tampus.data.repository

import com.dev_turtles.tampus.data.api.ApiService
import com.dev_turtles.tampus.data.model.LoginRequest
import com.dev_turtles.tampus.data.model.TokenResponse
import retrofit2.Call

class UserRepository(private val apiService: ApiService) {
    fun authenticate(credentials: LoginRequest): Call<TokenResponse> {
        return apiService.authenticate(credentials)
    }
}
