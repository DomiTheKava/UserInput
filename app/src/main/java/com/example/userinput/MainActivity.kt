package com.example.userinput

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {


    val costPerHour = 1.50
    var numberOfHours: Int = 0
    var totalCharges: Double = 0.00
    var lotChoice = ""


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hours: EditText = findViewById(R.id.txtHours)
        val group: Spinner = findViewById(R.id.spnGroup)
        val charges: Button = findViewById(R.id.calculateCharges)
        val result: TextView = findViewById(R.id.txtResult)

        charges.setOnClickListener {
            numberOfHours = hours.text.toString().toIntOrNull() ?: 0
            println(numberOfHours)

            val currency = DecimalFormat("$###,###.00")
            totalCharges = costPerHour * numberOfHours.toDouble()
            lotChoice = group.selectedItem.toString()
            val totalChargesFormatted = currency.format(totalCharges)

            result.text = "Cost for parking in $lotChoice for $numberOfHours hours is $totalChargesFormatted"
        }

    }
}