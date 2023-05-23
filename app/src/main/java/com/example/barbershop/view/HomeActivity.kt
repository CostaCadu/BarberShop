package com.example.barbershop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barbershop.R
import com.example.barbershop.adapter.ServicesAdapter
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.model.Services

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicesAdapter: ServicesAdapter
    private val arrayServices: MutableList<Services> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.extras?.getString("name")

        binding.tvWelcome.text = "Bem-vindo, $name!"
        val recyclerViewService = binding.recyclerViewService
        recyclerViewService.layoutManager = GridLayoutManager(this, 2)
        servicesAdapter = ServicesAdapter(this, arrayServices)
        recyclerViewService.setHasFixedSize(true)
        recyclerViewService.adapter = servicesAdapter
        getServices()

        binding.btnSchedule.setOnClickListener {
            val intent = Intent (this, Scheduling::class.java)
            intent.putExtra("nome", name)
            startActivity(intent)
        }
    }

    private fun getServices(){

        val service1 = Services(R.drawable.img1, "Corte de cabelo")
        arrayServices.add(service1)

        val service2 = Services(R.drawable.img2, "Corte de barba")
        arrayServices.add(service2)

        val service3 = Services(R.drawable.img3, "Lavagem de Cabelo")
        arrayServices.add(service3)

        val service4 = Services(R.drawable.img4, "Tratamento de cabelo")
        arrayServices.add(service4)
    }
}