package com.example.examen2eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val nombre=intent.getStringExtra("nombre")
        val nota=intent.getStringExtra("nota")
        val empresa=intent.getStringExtra("empresa")
        val anio=intent.getStringExtra("anio")

        val nom=findViewById<TextView>(R.id.textView)
        val not=findViewById<TextView>(R.id.textView3)
        val emp=findViewById<TextView>(R.id.textView4)
        val ani=findViewById<TextView>(R.id.textView5)
        val boton= findViewById<Button>(R.id.button4)
        val atras= findViewById<Button>(R.id.button5)
        val guardar=findViewById<Button>(R.id.button6)



        val juego=Videojuego(nombre!!, nota.toString().toDouble(), empresa!!, anio.toString().toInt())

        val BDJ = JuegosComprados(this)

        nom.text=nombre
        not.text=nota
        emp.text=empresa
        ani.text=anio

        guardar.setOnClickListener {
            BDJ.escribir(juego)
            val intent = Intent(this@ThirdActivity, SaveActivity::class.java)
            startActivity(intent)
        }
        boton.setOnClickListener {
            val intent = Intent(this@ThirdActivity, MainActivity::class.java)
            startActivity(intent)
        }
        atras.setOnClickListener {
            val intent = Intent(this@ThirdActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}