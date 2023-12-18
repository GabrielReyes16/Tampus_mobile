package com.dev_turtles.tampus.ui.view


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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnRegister.setOnClickListener {
            // Aquí podrías realizar alguna validación o simplemente no hacer nada si no es necesario
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
