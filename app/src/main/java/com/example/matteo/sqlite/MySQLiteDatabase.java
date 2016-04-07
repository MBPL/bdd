package com.example.matteo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Matteo on 05/04/2016.
 */

/**
 * Cette classe permet de créer la base de données ainsi que la table qui contiendra les utilisateurs.
 */
public class MySQLiteDatabase extends SQLiteOpenHelper {

    private static final String TABLE_UTILISATEURS = "table_utilisateurs";
    private static final String COL_ID = "ID";
    private static final String COL_NOM = "NOM";
    private static final String COL_PRENOM = "PRENOM";


    public MySQLiteDatabase(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final String CREATE_TABLE_UTILISATEURS = "CREATE TABLE "
            + TABLE_UTILISATEURS + " (" + COL_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM
            + " TEXT NOT NULL, " + COL_PRENOM + " TEXT NOT NULL, "
            + TABLE_UTILISATEURS + " TEXT NOT NULL);";


    /**
     * Cette méthode est appelée lors de la toute première création de la base
     * de données.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on crée la table table_contacts dans la BDD
        db.execSQL(CREATE_TABLE_UTILISATEURS);
    }

    /**
     * Ici c'est quand on mets à jour la base de donnée
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on supprime la table table_contacts de la BDD et on recrée la BDD
        db.execSQL("DROP TABLE " + TABLE_UTILISATEURS + ";");
        onCreate(db);
    }
}
