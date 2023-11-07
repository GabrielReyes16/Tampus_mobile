package com.dev_turtles.tampus.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.dev_turtles.tampus.util.SharedPreferenceUtil
import com.dev_turtles.tampus.data.model.User
import com.dev_turtles.tampus.databinding.ActivityLoginBinding
class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also{
            it.setSharedPreference(this)
        }
        binding.btnLogin.setOnClickListener{
            startlogin()
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

        }
    }
    fun startlogin(){
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        val user: User? = sharedPreferenceUtil.getUser()

        if(email == user?.email && password == user.password){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            Toast.makeText(this,"Error al acceder.", Toast.LENGTH_SHORT).show()
        }
    }
}