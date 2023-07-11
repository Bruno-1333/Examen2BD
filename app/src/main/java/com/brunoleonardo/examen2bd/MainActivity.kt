package com.brunoleonardo.examen2bd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.brunoleonardo.examen2bd.BD.DBHandler
import com.brunoleonardo.examen2bd.BD.Matiere
import com.brunoleonardo.examen2bd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // ici on ajoute et déclare une variable de type ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // ici on ajoute et initialise la variable
        setContentView(binding.root) // ici on change et déclare le layout

        //initialisation de la base de données
        val db = DBHandler(this) // ici on ajoute et déclare une variable de type BDHelper
        db.deleteToutesMatieres()

        db.ajouter(Matiere("Ordinateur et Resseau", 1, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Images Numerique", 1, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Logique de Programation", 1, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Intregation Web 1", 1, 60.0, "WEB")) // ici on ajoute une matière

        db.ajouter(Matiere("Programation Mobile", 2, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Intregation Web 2", 2, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Programation Web 1", 2, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Programation Web 2", 2, 60.0, "WEB")) // ici on ajoute une matière

        db.ajouter(Matiere("Programation Web 3", 3, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Programation Web 4", 3, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Programation Web 5", 3, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Programation Web 6", 3, 60.0, "WEB")) // ici on ajoute une matière

        db.ajouter(Matiere("Programation Web 7", 4, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Programation Web 8", 4, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Programation Web 9", 4, 60.0, "WEB")) // ici on ajoute une matière
        db.ajouter(Matiere("Programation Web 10", 4, 60.0, "WEB")) // ici on ajoute une matière



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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nom_menu, menu) // ici on ajoute et déclare une variable de type Menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) { // ici on ajoute une condition
            R.id.itemInit -> { // ici on ajoute une condition
                Toast.makeText(this, "Item 1 select", Toast.LENGTH_LONG).show() // ici on ajoute un message
            }
            R.id.itemAcceuil -> { // ici on ajoute une condition
                Toast.makeText(this, "Item 2 select", Toast.LENGTH_LONG).show() // ici on ajoute un message
            }
        }
        return super.onOptionsItemSelected(item)
    }
}