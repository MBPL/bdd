package com.example.matteo.sqlite.oldTest;

/**
 * Created by Matteo on 05/04/2016.
 */
public class Utilisateur {
    private int id;

    private String nom;

    private String prenom;


    public Utilisateur() {

    }

    public Utilisateur(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    @Override
    public String toString() {
        return "[Utilisateur] id : " + id + " - nom , prenom : " + nom + ", "
                + prenom;
    }
}
