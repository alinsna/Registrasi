package com.example.registrasi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val editTextPhone: EditText = findViewById(R.id.editTextPhone)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val btnRegister: Button = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val selectedGenderId = radioGroupGender.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(selectedGenderId)

            // Membuat intent untuk mengirim data kembali ke LoginActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("EXTRA_NAME", editTextName.text.toString())
            intent.putExtra("EXTRA_EMAIL", editTextEmail.text.toString())
            intent.putExtra("EXTRA_PHONE", editTextPhone.text.toString())
            intent.putExtra("EXTRA_PASSWORD", editTextPassword.text.toString())
            intent.putExtra("EXTRA_GENDER", radioButton.text.toString())
            startActivity(intent)

            finish() // Tutup RegisterActivity setelah registrasi
        }
    }
}
