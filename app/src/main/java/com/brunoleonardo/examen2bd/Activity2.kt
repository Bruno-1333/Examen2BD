package com.brunoleonardo.examen2bd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brunoleonardo.examen2bd.databinding.Activity2Binding
import com.brunoleonardo.examen2bd.databinding.ActivityMainBinding

class Activity2 : AppCompatActivity() {
    lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recuperer les strings a partir de l'intent
        var nom = intent.getStringExtra("nom")
        var etape = intent.getStringExtra("etape")

        //Afficher les strings dans les textviews
        binding.txtNomActivity2.text = etape
        binding.txtEtapeActivity2.text = nom
    }
}