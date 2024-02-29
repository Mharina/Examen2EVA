package com.example.examen2eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nom= findViewById<EditText>(R.id.editTextText)
        val not= findViewById<EditText>(R.id.editTextText2)
        val boton = findViewById<Button>(R.id.button)


        boton.setOnClickListener {
            if (nom.text.isBlank()) {
                val intent = Intent(this@MainActivity, MainActivity::class.java)
                startActivity(intent)
            }else{
                if (not.text.toString().toDouble()<0||not.text.isBlank()||not.text.toString().toDouble()>10){
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)
                }else {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("nombre", nom.text.toString())
                    intent.putExtra("nota", not.text.toString())
                    startActivity(intent)
                }
            }
        }
    }
}