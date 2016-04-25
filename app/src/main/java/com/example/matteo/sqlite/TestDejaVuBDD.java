package com.example.matteo.sqlite;

/**
 * Created by Matteo on 14/04/2016.
 */


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;
import com.example.matteo.R;

/**
 * Tester d'inserer une méthode DejaVu dans la base, supprimer etc..
 */
public class TestDejaVuBDD extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bdd);


        final DejaVuManager dejaVuManager = new DejaVuManager(this);

        // On ouvre la base de données pour écrire dedans
        dejaVuManager.open();


        // Création et insertion de la méthode
        DejaVu methodeDejaVu = new DejaVu();
        dejaVuManager.addDejaVu(methodeDejaVu);


        // Récupération de la méthode
        final DejaVu dejaVuFromBdd = dejaVuManager.getDejaVu(1);
        // Si la methode à bien été ajouté à la BDD, on affiche les données
        // de la méthode dans un Toast
        if (dejaVuFromBdd != null) {
            Toast.makeText(TestDejaVuBDD.this, "received", Toast.LENGTH_LONG).show();


        }


        if (dejaVuFromBdd != null) {
            Toast.makeText(getBaseContext(), "Methode va etre supp bro !!", Toast.LENGTH_LONG).show();
            dejaVuManager.removeDejaVu(dejaVuFromBdd.getId());
        }

        dejaVuManager.close();

    }

}
