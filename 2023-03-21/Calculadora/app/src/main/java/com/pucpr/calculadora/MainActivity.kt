package com.pucpr.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun getDoubleFromEditText(id:Int):Double{
        val numEditText = findViewById<EditText>(id)
        return numEditText.text.toString().toDouble()
    }
    fun sumButtonClicked(view:View){
        val num1 = getDoubleFromEditText(R.id.number1EditText)
        val num2 = getDoubleFromEditText(R.id.number2EditText)

        var result = num1+num2
        findViewById<TextView>(R.id.resultTextView).text = getString(R.string.result)+result
    }
}