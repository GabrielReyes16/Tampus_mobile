package com.dev_turtles.tampus.ui

import android.content.Intent
import android.os.Bundle
import com.dev_turtles.tampus.util.SharedPreferenceUtil
import com.dev_turtles.tampus.data.model.User
import com.dev_turtles.tampus.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also{
            it.setSharedPreference(this)
        }
        binding.btnRegister.setOnClickListener{
            val userId="1"
            val userName = binding.edtUserName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val user = User(
                userId,
                userName,
                email,
                password
            )
            sharedPreferenceUtil.saveUser(user)
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.btnGoLogin.setOnClickListener{
        }
    }
}