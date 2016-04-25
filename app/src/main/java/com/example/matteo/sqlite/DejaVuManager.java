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
    private static final int NUM_COL_TENTATIVEREUSSIE = 16;
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

    public void open() {
        //on ouvre la table en lecture/écriture
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close() {
        //on ferme l'accès à la BDD
        db.close();
    }

    /**
     * Ajout d'une méthode DejaVu dans la base.
     *
     * @param djv
     * @return
     */
    public long addDejaVu(DejaVu djv) {


        ContentValues values = new ContentValues();
        values.put(COL_CATEGORIE, djv.getCategorie());
        values.put(COL_BRUTEFORCE, djv.getBruteForce());
        values.put(COL_DICTIONARYATTACK, djv.getDictionaryAttack());
        values.put(COL_SHOULDERSURFING, djv.getShoulderSurfing());
        values.put(COL_SMUDGEATTACK, djv.getSmudgeAttack());
        values.put(COL_EYETRACKING, djv.getEyeTracking());
        values.put(COL_SPYWARE, djv.getSpyWare());
        values.put(COL_ESPACEMDP, djv.getEspaceMdp());
        values.put(COL_INDICESECURITE, djv.getIndiceSecurite());
        values.put(COL_APPRENTISSAGE, djv.getApprentissage());
        values.put(COL_MEMORISATION, djv.getMemorisation());
        values.put(COL_TEMPS, djv.getTemps());
        values.put(COL_SATISFACTION, djv.getSatisfaction());
        values.put(COL_INDICEUTILISABILITE, djv.getIndiceUtilisabilite());
        values.put(COL_TENTATIVEREUSSIE, djv.getNb_tentative_reussie());
        values.put(COL_TENTATIVEECHOUEE, djv.getNb_tentative_echouee());
        values.put(COL_TEMPSMOYEN, djv.getTemps_auth_moyen());
        values.put(COL_MDP, djv.getEspaceMdp());
        values.put(COL_STATS, 0);

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insertWithOnConflict(TABLE_NAME, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

    }


    public int removeDejaVu(int id) {
        return db.delete(TABLE_NAME, COL_ID + " = " + id, null);
    }

    /**
     * Retourne la méthode DejaVu dont l'id est passé en paramètre.
     *
     * @param id
     * @return
     */
    public DejaVu getDejaVu(int id) {

        DejaVu djv = new DejaVu();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + "=" + id, null);
        if (c.moveToFirst()) {

            djv.setId(c.getInt(c.getColumnIndex(COL_ID)));
            djv.setNb_tentative_echouee(c.getColumnIndex(COL_TENTATIVEECHOUEE));
            djv.setNb_tentative_reussie(c.getColumnIndex(COL_TENTATIVEREUSSIE));
            djv.setTemps_auth_moyen((float) c.getColumnIndex(COL_TEMPSMOYEN));

            c.close();
        }

        return djv;
    }

    /**
     * Met à jour une méthode DejaVu en base de données.
     * @param id l'identifiant de la méthode à modifier
     * @param tentative_echouee les nouveaux paramètres
     * @param tentative_reussi
     * @param auth_moyen
     * @return
     */
    public int updateDejaVu(int id, int tentative_echouee, int tentative_reussi, float auth_moyen) {
        ContentValues values = new ContentValues();
        values.put(COL_TENTATIVEECHOUEE, tentative_echouee);
        values.put(COL_TENTATIVEREUSSIE, tentative_reussi);
        values.put(COL_TEMPSMOYEN, auth_moyen);

        return db.update(TABLE_NAME, values, COL_ID + " = " + id, null);
    }


}
