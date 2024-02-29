package com.example.examen2eva

import android.os.Parcel
import android.os.Parcelable

class Videojuego (var nombre:String, var nota:Double, var empresa:String, var anio:Int):Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun toString():String{
        return "Nombre $nombre, Valoración $nota, Empresa $empresa, Año $anio"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeDouble(nota)
        parcel.writeString(empresa)
        parcel.writeInt(anio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Videojuego> {
        override fun createFromParcel(parcel: Parcel): Videojuego {
            return Videojuego(parcel)
        }

        override fun newArray(size: Int): Array<Videojuego?> {
            return arrayOfNulls(size)
        }
    }

}