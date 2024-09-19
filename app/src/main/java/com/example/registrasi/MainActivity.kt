package com.example.registrasi


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var registeredEmail: String? = null
    private var registeredPassword: String? = null
    private var registeredName: String? = null
    private var registeredPhone: String? = null
    private var registeredGender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvGoToRegister: TextView = findViewById(R.id.tvGoToRegister)
        val editTextLoginEmail: EditText = findViewById(R.id.editTextLoginEmail)
        val editTextLoginPassword: EditText = findViewById(R.id.editTextLoginPassword)

        // Cek apakah ada data yang dikirim dari RegisterActivity
        registeredEmail = intent.getStringExtra("EXTRA_EMAIL")
        registeredPassword = intent.getStringExtra("EXTRA_PASSWORD")
        registeredName = intent.getStringExtra("EXTRA_NAME")
        registeredPhone = intent.getStringExtra("EXTRA_PHONE")
        registeredGender = intent.getStringExtra("EXTRA_GENDER")

        // Tombol untuk pergi ke RegisterActivity
        tvGoToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Tombol untuk login
        btnLogin.setOnClickListener {
            val emailInput = editTextLoginEmail.text.toString()
            val passwordInput = editTextLoginPassword.text.toString()

            // Validasi login (cek apakah email dan password cocok dengan yang didaftarkan)
            if (emailInput == registeredEmail && passwordInput == registeredPassword) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("EXTRA_NAME", registeredName)
                intent.putExtra("EXTRA_EMAIL", registeredEmail)
                intent.putExtra("EXTRA_PHONE", registeredPhone)
                intent.putExtra("EXTRA_GENDER", registeredGender)
                startActivity(intent)
            } else {
                // Tampilkan pesan jika email atau password salah
                Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
