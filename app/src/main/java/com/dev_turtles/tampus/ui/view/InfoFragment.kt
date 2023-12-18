package com.dev_turtles.tampus.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dev_turtles.tampus.R
import com.dev_turtles.tampus.util.SharedPreferenceUtil


class InfoFragment : Fragment() {

    private lateinit var tvCorreoValor: TextView
    private lateinit var btnLogout: Button
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        // Inicializar los elementos de la interfaz
        tvCorreoValor = view.findViewById(R.id.tvCorreoValor)
        btnLogout = view.findViewById(R.id.btnLogout)

        // Obtener una instancia de SharedPreferenceUtil utilizando el contexto del fragmento
        sharedPreferenceUtil = SharedPreferenceUtil.getInstance(requireContext())

        // Configurar el valor del correo
        val user = sharedPreferenceUtil.getUser()
        tvCorreoValor.text = user?.email ?: ""

        // Configurar el clic del botón de cierre de sesión
        btnLogout.setOnClickListener {
            // Realizar el cierre de sesión aquí
            sharedPreferenceUtil.clearUser()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}
