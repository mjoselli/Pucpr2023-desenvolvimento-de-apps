package com.pucpr.activities

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second"
        Singleton.title = "Second"
        //finish()
        title = if(intent.extras != null) intent.extras?.getString("title") else "title"
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this@SecondActivity)
        builder.setMessage("Atenção")
        builder.setTitle("Vc deseja realmente voltar?")
        builder.setNegativeButton(android.R.string.cancel,
            null)
        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            val intent = Intent()
            intent.putExtra("new", "Primeiro")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        builder.create().show()
    }

}