package com.example.examen2eva

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JuegosComprados(context: Context) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "JuegosComprados.db"
        private const val TABLA_VIDEOJUEGOS = "videojuego"
        private const val KEY_ID = ""
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_NOTA = "nota"
        private const val COLUMN_EMPRESA = "empresa"
        private const val COLUMN_ANIO = "anio"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_VIDEOJUEGOS ($KEY_ID INTEGER PRIMARY KEY, $COLUMN_NOMBRE TEXT, $COLUMN_NOTA NUMBER, $COLUMN_EMPRESA TEXT, $COLUMN_ANIO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_VIDEOJUEGOS")
        onCreate(db)
    }

    fun escribir(juego:Videojuego):Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE, juego.nombre)
            put(COLUMN_NOTA, juego.nota)
            put(COLUMN_EMPRESA, juego.empresa)
            put(COLUMN_ANIO, juego.anio)
        }
        val id= db.insert(TABLA_VIDEOJUEGOS, null, values)
        db.close()
        return id
    }


    @SuppressLint("Range")
    fun lectura(): ArrayList<Videojuego> {
        val lectura = ArrayList<Videojuego>()
        val selectQuery = "SELECT * FROM $TABLA_VIDEOJUEGOS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val nota = cursor.getDouble(cursor.getColumnIndex(COLUMN_NOTA))
                val empresa = cursor.getString(cursor.getColumnIndex(COLUMN_EMPRESA))
                val anio = cursor.getInt(cursor.getColumnIndex(COLUMN_ANIO))
                lectura.add(Videojuego(nombre, nota, empresa, anio))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lectura
    }

}