package com.dev_turtles.tampus.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dev_turtles.tampus.R

class MenuRegistrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuregistrar)

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            // Acción cuando se hace clic en el botón Back
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Opcional: Cierra la actividad actual si no quieres volver a ella con el botón de retroceso.
        }

        val btnRegisterAnfitrion: Button = findViewById(R.id.btnRegisterAnfitrion)
        btnRegisterAnfitrion.setOnClickListener {
            // Acción cuando se hace clic en el botón Register Anfitrion
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish() // Opcional: Cierra la actividad actual si no quieres volver a ella con el botón de retroceso.
        }
    }
}
