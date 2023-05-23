package com.example.barbershop.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.barbershop.databinding.ActivitySchedulingBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Scheduling : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulingBinding
    private val calendar: Calendar = Calendar.getInstance()
    private var date: String = ""
    private var hour: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulingBinding.inflate(layoutInflater)
        setContentView(binding.root)



        supportActionBar?.hide()
        val name = intent.extras?.getString("nome").toString()

        val datePiker = binding.datePicker
        binding.datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->

            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            var day = dayOfMonth.toString()
            val month: String

            if (dayOfMonth < 10) {
                day = "0$dayOfMonth"
            }

            if (monthOfYear < 10) {
                month = "" + (monthOfYear + 1)
            } else {
                month = (monthOfYear + 1).toString()
            }

            date = "$day / $month /$year"

        }

        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->

            val minuto: String

            if (minute < 10) {
                minuto = "0$minute"
            } else {
                minuto = minute.toString()
            }
            hour = "$hourOfDay:$minuto"
        }
        binding.timePicker.setIs24HourView(true)
        binding.btnSchedule.setOnClickListener {

            val barber1 = binding.Barber1
            val barber2 = binding.Barber2
            val barber3 = binding.Barber3

            when{
                hour.isEmpty() -> {
                    message(it, "Preencha o horário!", cor = "#FF0000" )

                }
                hour < "8:00" && hour > "19:00" ->{
                    message(it, "Barber Shor está Fechado - horário de atendimento das 08:00 às 19:00!", cor = "#FF0000" )
                }
                date.isEmpty() -> {
                    message(it, "Coloque uma Data!", cor = "#FF0000" )
                }
                barber1.isChecked && date.isNotEmpty() && hour.isNotEmpty() ->{
                    message(it, "Agendamento realizado com sucesso!", cor = "#FF03DAC5" )
                }
                barber2.isChecked && date.isNotEmpty() && hour.isNotEmpty() ->{
                    message(it, "Agendamento realizado com sucesso!", cor = "#FF03DAC5" )
                }
                barber3.isChecked && date.isNotEmpty() && hour.isNotEmpty() ->{
                    message(it, "Agendamento realizado com sucesso!", cor = "#FF03DAC5" )
                }
                else -> {
                    message(it, "Escolha um barbeiro!", cor = "#FF0000" )
                }
            }
        }
    }

    private fun message(view: View, message: String, cor: String){
        val snackBar = Snackbar.make(view, message,Snackbar.LENGTH_SHORT)
        snackBar.setBackgroundTint(Color.parseColor(cor))
        snackBar.setTextColor(Color.parseColor("#FFFFFF"))
        snackBar.show()
    }
}



