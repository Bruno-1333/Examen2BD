package com.brunoleonardo.examen2bd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.brunoleonardo.examen2bd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // ici on ajoute et déclare une variable de type ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // ici on ajoute et initialise la variable
        setContentView(binding.root) // ici on change et déclare le layout

        binding.btnSaisirNote.setOnClickListener { // ici on ajoute un listener pour le bouton
            var nom = binding.txtNom.text.toString() // ici on ajoute et déclare une variable de type String
            var etape = binding.spinner.selectedItem.toString() // ici on ajoute et déclare une variable de type String


            if(etape.equals(resources.getStringArray(R.array.EtapesSpinner)[0])) { // ici on ajoute une condition
                Toast.makeText(this, getString(R.string.msgErreurEtape), Toast.LENGTH_LONG).show() // ici on ajoute un message
            } else {
                var nom = binding.txtNom.text.toString() // ici on ajoute et déclare une variable de type String

                // crer un intent pour passer à l'activité 2
                var intent = Intent(this, Activity2::class.java) // ici on ajoute et déclare une variable de type Intent

                // Fair la passage des strings nom et etape à l'activité 2
                intent.putExtra("nom", nom) // ici on ajoute et déclare une variable de type Intent
                intent.putExtra("etape", etape) // ici on ajoute et déclare une variable de type Intent

                //Faire la passage vers l'activité 2
                startActivity(intent) // ici on ajoute et déclare une variable de type Intent


            }
        }
    }
}