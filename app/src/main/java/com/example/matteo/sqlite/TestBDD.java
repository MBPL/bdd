package com.example.matteo.sqlite;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.example.matteo.R;


/**
 * Created by Matteo on 06/04/2016.
 */
/**
 * Tester d'inserer un utilisateur, etc..^^
 */
public class TestBDD extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bdd);




        UtilisateursBDD contactBdd = new UtilisateursBDD(this);

        // On ouvre la base de données pour écrire dedans
        contactBdd.open();

        // Création et insertion d'un contact
        Utilisateur contact = new Utilisateur("MOUGEOT", "Matteo");
        contactBdd.insertUtilisateur(contact);



        // Récupération du contact
        Utilisateur contactFromBdd = contactBdd
                .getFirstUtilisateurWithNom("MOUGEOT");
        // Si le contact à bien été ajouté à la BDD, on affiche les données du
        // contact dans un Toast et on modifie son nom dans la BDD
        if (contactFromBdd != null) {
            Toast.makeText(this, contactFromBdd.toString(), Toast.LENGTH_LONG)
                    .show();
            contactFromBdd.setNom("LACHERAY");
            contactBdd.updateUtilisateur(contactFromBdd.getId(), contactFromBdd);
        }

        // Récupération du contact grâce à son nom
        contactFromBdd = contactBdd
                .getFirstUtilisateurWithNom("LACHERAY");
        // S'il existe un contact possédant ce nom dans la BDD, alors on
        // affiche ses données dans un Toast et on le supprime de la base de
        // données
        if (contactFromBdd != null) {
            Toast.makeText(this, contactFromBdd.toString(), Toast.LENGTH_LONG)
                    .show();
            contactBdd.removeUtilisateurWithID(contactFromBdd.getId());
        }

        contactBdd.close();
    }
}
