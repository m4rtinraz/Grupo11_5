package com.example.amigos_ruta

import android.app.Activity
import android.os.Bundle
import com.example.amigos_ruta.databinding.ActivityHomeBinding

class HomeActivity: Activity() {

    //se agrega para enlazar el login
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //se agrega para enlazar el loogin
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}