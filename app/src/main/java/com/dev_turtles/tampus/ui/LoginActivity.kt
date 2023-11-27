package com.dev_turtles.tampus.ui

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import com.dev_turtles.tampus.util.SharedPreferenceUtil
import com.dev_turtles.tampus.data.model.User
import com.dev_turtles.tampus.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnLoginGoogle.setOnClickListener {
            startLogin()
        }

        binding.btnLoginFacebook.setOnClickListener {
            startLogin()
        }

        val spannableString = SpannableString("¿No tiene una cuenta? Regístrese ahora")
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(this@LoginActivity, MenuRegistrarActivity::class.java)
                startActivity(intent)
            }
        }

        spannableString.setSpan(clickableSpan, 22, spannableString.length, 0)

        binding.tvRegistroAhora.text = spannableString
        binding.tvRegistroAhora.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun startLogin() {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        val user: User? = sharedPreferenceUtil.getUser()

        if (email == user?.email && password == user.password) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Error al acceder.", Toast.LENGTH_SHORT).show()
        }
    }
}
