package com.rakesh.week6assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUsername = findViewById(R.id.editTextUsername)
        etPassword = findViewById(R.id.editTextPassword)
        btLogin = findViewById(R.id.btnLogin)

        btLogin.setOnClickListener {
            Authentication()
        }
    }

    private fun Activity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun Authentication(){
        var username = etUsername.text.toString()
        var password = etPassword.text.toString()
            if (username == "softwarica"){
                if (password == "coventry"){
                    Activity()
                }else{
                    Toast.makeText(this, "Password incorrect", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Username or Password incorrect", Toast.LENGTH_SHORT).show();
            }
    }
}




