package com.dev_turtles.tampus.data.api

import com.dev_turtles.tampus.data.model.LoginRequest
import com.dev_turtles.tampus.data.model.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/authenticate")
    fun authenticate(@Body credentials: LoginRequest): Call<TokenResponse>
}
