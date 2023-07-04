package com.brunoleonardo.examen2bd.BD

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// ici on ajouter la classe DBHandler et on hérite de SQLiteOpenHelper
class DBHandler(var context : Context) :
    SQLiteOpenHelper(context,
        Constantes.NOM_BASE,
        null,
        Constantes.VERSION_BD) {

    override fun onCreate(db: SQLiteDatabase?) {
        // creation de la requete sql pour creer la table
        var sql = "CREATE TABLE ${Constantes.NOM_TABLE} (" +
                "${Constantes.ATTRIBUIT_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${Constantes.ATTRIBUIT_NOM_MATIERE} TEXT, " +
                "${Constantes.ATTRIBUIT_ETAPE} INTEGER, " +
                "${Constantes.ATTRIBUIT_NOTE_PASSAGE} REAL, " +
                "${Constantes.ATTRIBUIT_PROGRAMME} TEXT" +
                ")"

        // ici on execute la requete sql et on crée la table
        db?.execSQL(sql)
    }

    // ici on crée la fonction onUpgrade pour mettre à jour la base de données
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var sql = "DROP TABLE IF EXISTS ${Constantes.NOM_TABLE}"
        db?.execSQL(sql)

        onCreate(db)
    }

    // Ajouter une matiere a la table
    fun ajouter(matiere: Matiere){
        var db = this.writableDatabase // acces en ecriture a la base de donnees

        //Preparer notre ContentValue
        var contentValues = ContentValues()
        contentValues.put(Constantes.ATTRIBUIT_NOM_MATIERE, matiere.nomMatiere)
        contentValues.put(Constantes.ATTRIBUIT_ETAPE, matiere.etape)
        contentValues.put(Constantes.ATTRIBUIT_NOTE_PASSAGE, matiere.notePassage)
        contentValues.put(Constantes.ATTRIBUIT_PROGRAMME, matiere.programme)

        // Inserer la ligne dans la table
        db.insert(Constantes.NOM_TABLE, null, contentValues)

        // Fermer la connexion
        db.close()
    }

    fun deleteUneMatiere(id: Int){
        var db = this.writableDatabase // acces en ecriture a la base de donnees

        // Inserer la ligne dans la table
        db.delete(Constantes.NOM_TABLE,
            "${Constantes.ATTRIBUIT_ID} = ?",
            arrayOf(id.toString())
        )

        // Fermer la connexion
        db.close()
    }

    fun deleteToutesMatieres(){
        var db = this.writableDatabase // acces en ecriture a la base de donnees


        // Inserer la ligne dans la table
        db.delete(Constantes.NOM_TABLE,
            null,
            null)

        // Fermer la connexion
        db.close()
    }

    fun modifierMatiere(matiere: Matiere){
        var db = this.writableDatabase // acces en ecriture a la base de donnees

        //Preparer notre ContentValue
        var contentValues = ContentValues()
        contentValues.put(Constantes.ATTRIBUIT_NOM_MATIERE, matiere.nomMatiere)
        contentValues.put(Constantes.ATTRIBUIT_ETAPE, matiere.etape)
        contentValues.put(Constantes.ATTRIBUIT_NOTE_PASSAGE, matiere.notePassage)
        contentValues.put(Constantes.ATTRIBUIT_PROGRAMME, matiere.programme)

        // Inserer la ligne dans la table
        db.update(Constantes.NOM_TABLE,
            contentValues,
            "${Constantes.ATTRIBUIT_ID} = ?",
            arrayOf(matiere.id.toString())
        )

        // Fermer la connexion
        db.close()
    }

    fun selectionnerParId(id : Int) : Matiere{
        var db = this.readableDatabase // acces en lecture a la base de donnees

        db.query(Constantes.NOM_TABLE,
            arrayOf(Constantes.ATTRIBUIT_NOM_MATIERE,
                Constantes.ATTRIBUIT_ETAPE,
                Constantes.ATTRIBUIT_NOTE_PASSAGE,
                Constantes.ATTRIBUIT_PROGRAMME),
            "${Constantes.ATTRIBUIT_ID} = ?", // selectionner par id
            arrayOf(id.toString()),
            null,
            null,
            null)

        // Fermer la connexion
        db.close()
    }

}