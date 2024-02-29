package com.example.examen2eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nom=intent.getStringExtra("nombre")
        val not=intent.getStringExtra("nota")

        val empresa= findViewById<EditText>(R.id.editTextText3)
        val anio= findViewById<EditText>(R.id.editTextText4)
        val boton= findViewById<Button>(R.id.button2)
        val atras= findViewById<Button>(R.id.button3)

        boton.setOnClickListener {
            if (empresa.text.isBlank()) {
                val intent = Intent(this@SecondActivity, SecondActivity::class.java)
                startActivity(intent)
            }else {
                if (anio.text.toString().toInt() < 1700 || anio.text.toString().toInt() > 2024||anio.text.isBlank()) {
                    val intent = Intent(this@SecondActivity, SecondActivity::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                    intent.putExtra("nombre", nom)
                    intent.putExtra("nota", not)
                    intent.putExtra("empresa", empresa.text.toString())
                    intent.putExtra("anio", anio.text.toString())
                    startActivity(intent)
                }
            }
        }
        atras.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}