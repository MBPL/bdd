package com.example.matteo.sqlite;

/**
 * Created by Matteo on 08/04/2016.
 */

/**
 * Methode DejaVu
 */
public class DejaVu {


    private int id, bruteForce, dictionaryAttack, shoulderSurfing, smudgeAttack, eyeTracking, spyWare, espaceMdp;
    private int apprentissage, memorisation, temps, satisfaction, nb_tentative_reussie, nb_tentative_echouee;
    private String nom, categorie;
    private Float indiceSecurite, indiceUtilisabilite, temps_auth_moyen;


    public DejaVu() {
        this.id = 1;
        this.nom = "Déjà Vu";
        this.categorie = "reconnaissance";
        this.bruteForce = 0;
        this.dictionaryAttack = 2;
        this.shoulderSurfing = 2;
        this.smudgeAttack = 5;
        this.eyeTracking = 5;
        this.spyWare = 3;
        this.espaceMdp = 1;
        this.indiceSecurite = 2.57f;
        this.apprentissage = 2;
        this.memorisation = 3;
        this.temps = 3;
        this.satisfaction = 3;
        this.indiceUtilisabilite = 2.75f;

        this.nb_tentative_echouee = 0;
        this.nb_tentative_reussie = 0;
        this.temps_auth_moyen = 0f;
    }

    public int getId() {
        return id;
    }

    public int getBruteForce() {
        return bruteForce;
    }

    public int getDictionaryAttack() {
        return dictionaryAttack;
    }

    public int getSmudgeAttack() {
        return smudgeAttack;
    }

    public int getEspaceMdp() {
        return espaceMdp;
    }

    public int getTemps() {
        return temps;
    }

    public int getNb_tentative_echouee() {
        return nb_tentative_echouee;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public Float getIndiceSecurite() {
        return indiceSecurite;
    }

    public Float getIndiceUtilisabilite() {
        return indiceUtilisabilite;
    }

    public Float getTemps_auth_moyen() {
        return temps_auth_moyen;
    }

    public int getNb_tentative_reussie() {
        return nb_tentative_reussie;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public int getMemorisation() {
        return memorisation;
    }

    public int getApprentissage() {
        return apprentissage;
    }

    public int getSpyWare() {
        return spyWare;
    }

    public int getEyeTracking() {
        return eyeTracking;
    }

    public int getShoulderSurfing() {
        return shoulderSurfing;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNb_tentative_reussie(int nb_tentative_reussie) {
        this.nb_tentative_reussie = nb_tentative_reussie;
    }

    public void setNb_tentative_echouee(int nb_tentative_echouee) {
        this.nb_tentative_echouee = nb_tentative_echouee;
    }

    public void setTemps_auth_moyen(Float temps_auth_moyen) {
        this.temps_auth_moyen = temps_auth_moyen;
    }


}
