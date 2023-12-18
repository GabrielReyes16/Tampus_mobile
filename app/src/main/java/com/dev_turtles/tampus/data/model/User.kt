package com.dev_turtles.tampus.data.model

import java.io.Serializable

data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val birthDate: String
): Serializable{
    fun getImage() = "https://www.shutterstock.com/image-vector/blank-avatar-photo-place-holder-600nw-1095249842.jpg"
}
