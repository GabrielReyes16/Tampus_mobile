package com.dev_turtles.tampus.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dev_turtles.tampus.data.api.ApiClient
import com.dev_turtles.tampus.data.repository.UserRepository
import com.dev_turtles.tampus.databinding.ActivityLoginBinding
import com.dev_turtles.tampus.ui.viewmodel.LoginResult
import com.dev_turtles.tampus.ui.viewmodel.LoginViewModel
import com.dev_turtles.tampus.ui.viewmodel.LoginViewModelFactory

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var viewModel: LoginViewModel
    // Suponiendo que tienes una clase llamada ApiClient que crea instancias de ApiService
    val apiService = ApiClient.create()  // Ajusta según tu implementación

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear una instancia de UserRepository utilizando ApiService
        val userRepository = UserRepository(apiService)

        // Crear una instancia de LoginViewModelFactory con UserRepository
        val viewModelFactory = LoginViewModelFactory(userRepository)

        // Inicializar el ViewModel utilizando el ViewModelProvider y el Factory
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

        // Observar cambios en el resultado de la autenticación
        viewModel.loginResult.observe(this, Observer { result ->
            when (result) {
                is LoginResult.Success -> {
                    // Navegar a la siguiente pantalla o realizar otras acciones
                    startActivity(Intent(this, MainActivity::class.java))
                }
                is LoginResult.Error -> {
                    // Mostrar un mensaje de error al usuario
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

        // Configurar el click en el botón de inicio de sesión
        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            // Llamar al método del ViewModel para autenticar
            viewModel.authenticate(email, password)
        }

        binding.tvRegistroAhora.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

