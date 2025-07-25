package com.fajrifarid.unitconverterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val buttonCelcius by lazy { findViewById<Button>(R.id.btn_celcius) }
    private val buttonFahrenheit by lazy { findViewById<Button>(R.id.btn_fahrenheit) }
    private val tvInput by lazy { findViewById<TextView>(R.id.tv_input) }
    private val tvOutput by lazy { findViewById<TextView>(R.id.tv_output) }
    private val btnSwap by lazy { findViewById<Button>(R.id.btn_swap) }

    private val btnOne by lazy { findViewById<Button>(R.id.btn_1) }
    private val btnTwo by lazy { findViewById<Button>(R.id.btn_2) }
    private val btnThree by lazy { findViewById<Button>(R.id.btn_3) }
    private val btnC by lazy { findViewById<Button>(R.id.btn_c) }

    private val btnFour by lazy { findViewById<Button>(R.id.btn_4) }
    private val btnFive by lazy { findViewById<Button>(R.id.btn_5) }
    private val btnSix by lazy { findViewById<Button>(R.id.btn_6) }
    private val btnAdd by lazy { findViewById<Button>(R.id.btn_add) }

    private val btnSeven by lazy { findViewById<Button>(R.id.btn_7) }
    private val btnEight by lazy { findViewById<Button>(R.id.btn_8) }
    private val btnNine by lazy { findViewById<Button>(R.id.btn_9) }
    private val btnSub by lazy { findViewById<Button>(R.id.btn_sub) }

    private val btnZero by lazy { findViewById<Button>(R.id.btn_0) }
    private val btnDot by lazy { findViewById<Button>(R.id.btn_dot) }
    private val btnConvert by lazy { findViewById<Button>(R.id.btn_convert) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSwap.setOnClickListener {
            animateInputIndicator()
        }
    }

    private fun animateInputIndicator(){
        // Get initial position
        val initialY1 = buttonCelcius.y
        val initialY2 = buttonFahrenheit.y

        // Animate button celcius
        buttonCelcius.animate()
            .alpha(0f)
            .y(initialY2)
            .setDuration(300) // Adjust the duration as needed
            .withEndAction{
                buttonCelcius.alpha = initialY2
                buttonCelcius.alpha = 1f
            }

        // Animate button celcius
        buttonFahrenheit.animate()
            .alpha(0f)
            .y(initialY1)
            .setDuration(300) // Adjust the duration as needed
            .withEndAction{
                buttonFahrenheit.alpha = initialY1
                buttonFahrenheit.alpha = 1f
            }
    }
}