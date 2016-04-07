package com.example.matteo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Matteo on 05/04/2016.
 */

/**
 * Permet d'intéragir avec la base de donnée  (manipuler les données)
 */
public class UtilisateursBDD {


        private static final int VERSION_BDD = 1;
        private static final String NOM_BDD = "utilisateur.db";

        private static final String TABLE_UTILISATEURS = "table_utilisateurs";
        private static final String COL_ID = "ID";
        private static final int NUM_COL_ID = 0;
        private static final String COL_NOM = "NOM";
        private static final int NUM_COL_NOM = 1;
        private static final String COL_PRENOM = "PRENOM";
        private static final int NUM_COL_PRENOM = 2;

        private SQLiteDatabase bdd;

        private MySQLiteDatabase maBaseSQLite;

        public UtilisateursBDD(Context context) {
            maBaseSQLite = new MySQLiteDatabase(context, NOM_BDD, null, VERSION_BDD);
        }

        /**
         * Ouvre la BDD en écriture
         */
        public void open() {
            bdd = maBaseSQLite.getWritableDatabase();
        }

        /**
         * Ferme l'accès à la BDD
         */
        public void close() {
            bdd.close();
        }

        public SQLiteDatabase getBDD() {
            return bdd;
        }

        /**
         * Insère un utilisateur en base de données
         *
         * @param utilisateur
         *            le contact à insérer
         * @return l'identifiant de la ligne insérée
         */
        public long insertUtilisateur(Utilisateur utilisateur) {
            ContentValues values = new ContentValues();

            // On insère les valeurs dans le ContentValues : on n'ajoute pas
            // l'identifiant car il est créé automatiquement
            values.put(COL_NOM, utilisateur.getNom());
            values.put(COL_PRENOM, utilisateur.getPrenom());


            //return bdd.insert(TABLE_UTILISATEURS, null, values);
            return bdd.insertWithOnConflict(TABLE_UTILISATEURS, null,
                    values, SQLiteDatabase.CONFLICT_IGNORE);

        }

        /**
         * Met à jour l'utilisateur en base de données
         *
         * @param id
         *            l'identifiant de l'utilisateur à modifier
         * @param utilisateur
         *            le nouveau utilisateur à associer à l'identifiant
         * @return le nombre de lignes modifiées
         */
        public int updateUtilisateur(int id, Utilisateur utilisateur) {
            ContentValues values = new ContentValues();
            values.put(COL_NOM, utilisateur.getNom());
            values.put(COL_PRENOM, utilisateur.getPrenom());

            return bdd.update(TABLE_UTILISATEURS, values, COL_ID + " = " + id, null);
        }

        /**
         * Supprime un contact de la BDD (celui dont l'identifiant est passé en
         * paramètres)
         *
         * @param id
         *            l'identifiant de l'utilisateur à supprimer
         * @return le nombre de contacts supprimés
         */
        public int removeUtilisateurWithID(int id) {
            return bdd.delete(TABLE_UTILISATEURS, COL_ID + " = " + id, null);
        }


        public Utilisateur getFirstUtilisateurWithNom(String name) {
            Cursor c = bdd.query(TABLE_UTILISATEURS, new String[] { COL_ID, COL_NOM,
                    COL_PRENOM }, NUM_COL_NOM + " LIKE \""
                    + name + "\"", null, null, null, null);
            return cursorToUtilisateur(c);
        }



        /**
         * Convertit le cursor en utilisateur
         *
         * @param c
         *            le cursor à convertir
         * @return le Contact créé à partir du Cursor
         */
        private Utilisateur cursorToUtilisateur(Cursor c) {
            // si aucun élément n'a été retourné dans la requête, on renvoie null
            if (c.getCount() == 0)
                return null;

            // Sinon on se place sur le premier élément
            c.moveToFirst();

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(c.getInt(NUM_COL_ID));
            utilisateur.setNom(c.getString(NUM_COL_NOM));
            utilisateur.setPrenom(c.getString(NUM_COL_PRENOM));

            c.close();

            return utilisateur;
        }

}
