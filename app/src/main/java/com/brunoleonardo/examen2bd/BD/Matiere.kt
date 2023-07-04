package com.brunoleonardo.examen2bd.BD

// ici on ajoute et déclare une classe et le constructeur
class Matiere(val id: Int,
              val nomMatiere: String,
              val etape: Int,
              val notePassage: Double,
              val programme: String) {

    // ici on declare le second constructeur
    constructor(nomMatiere: String,
                etape: Int,
                notePassage: Double,
                programme: String)
            : this(0, nomMatiere, etape, notePassage, programme)

}

