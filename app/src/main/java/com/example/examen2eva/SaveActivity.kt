package com.example.examen2eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val boton= findViewById<Button>(R.id.button7)
        val textoJuegos=findViewById<TextView>(R.id.textView2)

//        val BDJ = JuegosComprados(this)
//        textoJuegos.text=BDJ.lectura().toString()

        boton.setOnClickListener {
            val intent = Intent(this@SaveActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}