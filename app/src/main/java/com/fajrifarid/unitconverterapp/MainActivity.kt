package com.fajrifarid.unitconverterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private val buttonCelcius by lazy { findViewById<Button>(R.id.btn_celcius) }
    private val buttonFahrenheit by lazy { findViewById<Button>(R.id.btn_fahrenheit) }
    private val tvInput by lazy { findViewById<TextView>(R.id.tv_input) }
    private val tvOutput by lazy { findViewById<TextView>(R.id.tv_output) }
    private val btnSwap by lazy { findViewById<Button>(R.id.btn_swap) }

    private val btnOne by lazy { findViewById<Button>(R.id.btn_1) }
    private val btnTwo by lazy { findViewById<Button>(R.id.btn_2) }
    private val btnThree by lazy { findViewById<Button>(R.id.btn_3) }
    private val btnClear by lazy { findViewById<Button>(R.id.btn_c) }

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
        observeInput()
        observeOutput()

        btnOne.setButtonClickListener("1")
        btnTwo.setButtonClickListener("2")
        btnThree.setButtonClickListener("3")
        btnFour.setButtonClickListener("4")
        btnFive.setButtonClickListener("5")
        btnSix.setButtonClickListener("6")
        btnSeven.setButtonClickListener("7")
        btnEight.setButtonClickListener("8")
        btnNine.setButtonClickListener("9")
        btnZero.setButtonClickListener("0")
        btnDot.setButtonClickListener(".")
        btnAdd.setButtonClickListener("+")
        btnSub.setButtonClickListener("-")

        btnClear.setOnClickListener{
            viewModel.clearInput()
        }

        btnSwap.setOnClickListener {
            animateInputIndicator()
            viewModel.switchInputUnit()
            viewModel.resetInputAndOutput()
        }

        btnConvert.setOnClickListener{
            viewModel.convertUnit()
        }
    }

    private fun observeOutput(){
        viewModel.output.observe(this){
            output -> tvOutput.text = output
        }
    }

    private fun observeInput(){
        viewModel.input.observe(this){
            input -> tvInput.text = input
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

    private fun Button.setButtonClickListener(value: String){
        setOnClickListener {
            viewModel.setInput(value)
        }
    }
}