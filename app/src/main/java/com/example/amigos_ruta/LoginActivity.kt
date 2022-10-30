package com.example.amigos_ruta

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.example.amigos_ruta.databinding.ActivityLoginBinding

class LoginActivity : Activity(){

    //se agrega para enlazar el login
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //se agrega para enlazar el loogin
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //para llamar la funcion validar
        binding.ingresar.setOnClickListener { validar() }

        //para llamar la funcion enviarregistrar
        binding.registrar.setOnClickListener { enviarRegistrar() }
    }
    //funcion encargada de validar el ingreso de datos de correo y contraseña en la base de datos

    fun validar(){
        val correo:String=binding.email.text.toString()
        val password:String=binding.password.text.toString()

        var pref=getSharedPreferences(correo, Context.MODE_PRIVATE)

        var email_bd=pref.getString("email", "")
        var pass_bd=pref.getString("contrasena","")
        var nombre_bd=pref.getString("nombre","")
        var apel_bd=pref.getString("apellido","")



        if(correo.isEmpty()){
            binding.email.setHint("Ingrese su correo")
            binding.email.setHintTextColor(Color.RED)
            Toast.makeText(this,"Ingrese su correo", Toast.LENGTH_LONG).show()
        }else if(password.isEmpty()){
            binding.password.setHint("Ingrese su contraseña")
            binding.password.setHintTextColor(Color.RED)
            Toast.makeText(this,"Ingrese su contraseña", Toast.LENGTH_LONG).show()
        }else if(correo==email_bd) //"c1@email.com" para hacer la prueba inicial de verificacion de correo
            if(password==pass_bd){ //"c123" para hacer la pruebainicial de verificacion de password
                Toast.makeText(this,"Bienvenido...$nombre_bd $apel_bd", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_LONG).show()
            }
        else{
            Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG).show()
        }
    }

    //funcion que llama la pantalla de registro
    fun enviarRegistrar(){
        startActivity(Intent(this, RegistrarActivity::class.java))
    }
}