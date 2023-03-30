package com.pucpr.mydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.pucpr.mydatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.text_view).apply {
            text = "Hello"
        }*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.textView.apply {
            text = "hello"
        }

        binding.apply {
            textView.text = "Olá"
            button.text = "Botão"
        }
        binding.button.setOnClickListener{
            binding.textView.text = "button pressed"
        }
        val user = User("mark","mark@pucpr.br")
        /*binding.apply {
            nameTextView.text = user.name
            emailTextView.text = user.email
        }*/
        binding.user = user
        binding.user.name = "sdfsd"
    }
}