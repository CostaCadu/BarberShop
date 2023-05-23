package com.example.barbershop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.barbershop.databinding.ActivityMainBinding

import com.example.barbershop.view.HomeActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {

            val name = binding.tvName.text.toString()
            val password = binding.tvPassword.text.toString()

            when{
                name.isEmpty() -> {
                    message(it,"Coloque seu nome!")
                } password.isEmpty() -> {
                    message(it,"Preencha sua senha!")
                } password.length <=5 -> {
                    message(it,"A senha precisa ter pelo menos 6 caracteres!")
                } else -> {
                    navigateHomePage(name)
                }
            }
        }
    }
    private fun message(view: View, message:String){
        val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackBar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackBar.setTextColor(Color.parseColor("#FFFFFF"))
        snackBar.show()
    }

    private fun navigateHomePage (name: String) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("name",name)
        startActivity(intent)
    }
}