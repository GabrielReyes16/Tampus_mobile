package com.dev_turtles.tampus.ui

import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.app.DatePickerDialog
import com.dev_turtles.tampus.util.SharedPreferenceUtil
import com.dev_turtles.tampus.data.model.User
import com.dev_turtles.tampus.databinding.ActivityRegisterBinding
import java.util.Calendar

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        binding.btnRegister.setOnClickListener {
            val userId = "1"
            val userName = binding.edtUserName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val birthDate = binding.edtFechaNacimiento.text.toString()

            val user = User(
                userId,
                userName,
                email,
                password,
                birthDate
            )

            sharedPreferenceUtil.saveUser(user)
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.edtFechaNacimiento.setOnClickListener {
            showDatePickerDialog(binding.edtFechaNacimiento)
        }
    }

    private fun showDatePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                editText.setText(selectedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
}
