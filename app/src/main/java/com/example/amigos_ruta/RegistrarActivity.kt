package com.example.amigos_ruta

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.amigos_ruta.databinding.ActivityRegistrarBinding

class RegistrarActivity : Activity() {
    //hace el llamdo y manejo del tiempo
    lateinit var binding: ActivityRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //se agrega para traer todos los componenetes de la pantalla
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registro.setOnClickListener{guardarUsuario()}
    }

    fun guardarUsuario(){
        val nombre:String = binding.nombre.text.toString()
        val apellido:String = binding.apellido.text.toString()
        val telefono:String = binding.telefono.text.toString()
        val correo:String = binding.correo.text.toString()
        val contrasena:String = binding.contrasena.text.toString()
        val genero:Int = binding.genero.id

        //para poder guardar los datos dentro del equipo
        var pref=getSharedPreferences(correo, Context.MODE_PRIVATE)
        //SE CREA PARA HACER EL REGISTRO PARA QUE SE GUARDEN
        var editar=pref.edit()
        editar.putString("email",correo)
        editar.putString("nombre",nombre)
        editar.putString("apellido",apellido)
        editar.putString("telefono",telefono)
        editar.putString("contrasena",contrasena)
        if(genero==0){
            editar.putString("genero", "Mujer")
        }else{
            editar.putString("genero", "Hombre")
        }
        //para ejecutar la accion deguardar en la memoria del equipo
        editar.commit()
        Toast.makeText(this, "El usuario se registro exitosamente", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}