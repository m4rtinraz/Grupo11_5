package com.example.amigos_ruta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.amigos_ruta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //hace el llamdo y manejo del tiempo
    lateinit var binding: ActivityMainBinding
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //se agrega para traer todos los componenetes de la pantalla
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //como la funcion handler ya aparece deprecada se usa el looper para forzar su uso
        handler =Handler(Looper.myLooper()!!)

        //para crfear lo que va a psasar despues del tiempo de espera
        handler.postDelayed({
            //intent instancia de la ventana identificandla para hacer el cambio y se agrega el tiempo
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },5000)
    }
}