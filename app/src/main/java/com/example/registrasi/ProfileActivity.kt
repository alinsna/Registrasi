package com.example.registrasi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewEmail: TextView = findViewById(R.id.textViewEmail)
        val textViewPhone: TextView = findViewById(R.id.textViewPhone)
        val textViewGender: TextView = findViewById(R.id.textViewGender)

        // Ambil data dari Intent
        val name = intent.getStringExtra("EXTRA_NAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val phone = intent.getStringExtra("EXTRA_PHONE")
        val gender = intent.getStringExtra("EXTRA_GENDER")

        // Tampilkan data di halaman profil
        textViewName.text = "Nama: $name"
        textViewEmail.text = "Email: $email"
        textViewPhone.text = "Nomor HP: $phone"
        textViewGender.text = "Jenis Kelamin: $gender"
    }
}

