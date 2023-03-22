package com.pucpr.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var button:Button
    val resultLaucher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            val data = result.data
            val aux: String? = data?.getStringExtra("new")
            title = aux ?: "Title"
        }
    }
    val lista = listOf<String>("Maça","Banana","Abacaxi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("Lifecycle","onCreate")
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_item,
            lista
        )
        spinner.adapter = adapter

        button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("title","legal")
            Singleton.title = "voltou"
            //startActivity(intent)
            resultLaucher.launch(intent)
        }
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }*/

    override fun onStart() {
        super.onStart()
        Log.w("Lifecycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.wtf("Lifecycle","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.wtf("Lifecycle","onPause")

    }
}