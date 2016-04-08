package com.example.matteo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by Matteo on 08/04/2016.
 */

/**
 * Permet d'intéragir avec la base de donnée  (manipuler les données)
 */
public class DejaVuManager {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "methode.db";

    private static final String TABLE_NAME = "table_methode";
    private static final String COL_ID = "methode_id";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NOM = "methode_name";
    private static final int NUM_COL_NOM = 1;
    private static final String COL_CATEGORIE = "categorie";
    private static final int NUM_COL_CATEGORIE = 2;
    private static final String COL_BRUTEFORCE = "bruteForce";
    private static final int NUM_COL_BRUTEFORCE = 3;
    private static final String COL_DICTIONARYATTACK = "dictionaryAttack";
    private static final int NUM_COL_DICTIONARYATTACK = 4;
    private static final String COL_SHOULDERSURFING = "shoulderSurfing";
    private static final int NUM_COL_SHOULDERSURFING = 5;
    private static final String COL_SMUDGEATTACK = "smudgeAttack";
    private static final int NUM_COL_SMUDGEATTACK = 6;
    private static final String COL_EYETRACKING = "eyeTracking";
    private static final int NUM_COL_EYETRACKING = 7;
    private static final String COL_SPYWARE = "spyWare";
    private static final int NUM_COL_SPYWARE = 8;
    private static final String COL_ESPACEMDP = "espaceMdp";
    private static final int NUM_COL_ESPACEMDP = 9;
    private static final String COL_INDICESECURITE = "indiceSecurite";
    private static final int NUM_COL_INDICESECURITE = 10;
    private static final String COL_APPRENTISSAGE = "apprentissage";
    private static final int NUM_COL_APPRENTISSAGE = 11;
    private static final String COL_MEMORISATION = "memorisation";
    private static final int NUM_COL_MEMORISATION = 12;
    private static final String COL_TEMPS = "temps";
    private static final int NUM_COL_TEMPS = 13;
    private static final String COL_SATISFACTION = "satisfaction";
    private static final int NUM_COL_SATISFACION = 14;
    private static final String COL_INDICEUTILISABILITE = "indiceUtilisabilite";
    private static final int NUM_COL_INDICEUTILISABILITE = 15;
    private static final String COL_TENTATIVEREUSSIE = "nb_tentative_reussie";
    private static final int NUM_COL_TENTATIVEREUSSIE= 16;
    private static final String COL_TENTATIVEECHOUEE = "nb_tentative_echouee";
    private static final int NUM_COL_TENTATIVEECHOUEE = 17;
    private static final String COL_TEMPSMOYEN = "temps_auth_moyen";
    private static final int NUM_COL_TEMPSMOYEN = 18;
    private static final String COL_MDP = "mdp";
    private static final int NUM_COL_MDP = 19;
    private static final String COL_STATS = "statistique";
    private static final int NUM_COL_STATS = 20;

    private SQLiteDatabase db;
    private MySQLiteDatabase maBaseSQLite;

    public DejaVuManager(Context context) {
        maBaseSQLite = new MySQLiteDatabase(context, NOM_BDD, null, VERSION_BDD);
    }




    public void open()
    {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }

    /*
    public long addAnimal(Animal animal) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_NOM_ANIMAL, animal.getNom_animal());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int modAnimal(Animal animal) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_NOM_ANIMAL, animal.getNom_animal());

        String where = KEY_ID_ANIMAL+" = ?";
        String[] whereArgs = {animal.getId_animal()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supAnimal(Animal animal) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_ANIMAL+" = ?";
        String[] whereArgs = {animal.getId_animal()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Animal getAnimal(int id) {
        // Retourne l'animal dont l'id est passé en paramètre

        Animal a=new Animal(0,"");

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_ANIMAL+"="+id, null);
        if (c.moveToFirst()) {
            a.setId_animal(c.getInt(c.getColumnIndex(KEY_ID_ANIMAL)));
            a.setNom_animal(c.getString(c.getColumnIndex(KEY_NOM_ANIMAL)));
            c.close();
        }

        return a;
    }

    public Cursor getAnimaux() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
    */


}
