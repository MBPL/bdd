package com.example.matteo.matteo1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;


import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.matteo.R;


public class MainActivity extends ActionBarActivity {

    private final int nbIcone = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridLayout myLayout = new GridLayout(this);

        // Cache la barre d'action
        android.support.v7.app.ActionBar toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.hide();
        }

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y - getStatusBarHeight();

        int nbLigne = 4;
        int nbColonne = 4;
        myLayout.setColumnCount(nbColonne);
        myLayout.setRowCount(nbLigne);

        for (int l = 0; l < nbLigne; l++) {
            for (int c = 0; c < nbColonne; c++) {

                ImageView iv;
                iv = new ImageView(this);

                // Crée un bitmap d'une icone piochée aléatoirement
                final int n = randomInto(1, nbIcone);
                Bitmap bmp;
                bmp = BitmapFactory.decodeResource(getResources(), getDrawableN(n));
                bmp = Bitmap.createScaledBitmap(bmp, 96, 96, true); // les icones prennent moins de place en mémoire après cette méthode

                // On ajoute l'icone à l'ImageView
                iv.setImageBitmap(bmp);

                // Ajoute un listener sur l'icon
                /*iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "" + n, Toast.LENGTH_SHORT).show();
                    }
                });*/

                // On ajoute l'ImageView au GridLayout en mettant les bon paramétres
                GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                param.height = screenHeight / nbLigne;
                param.width = screenWidth / nbColonne;
                param.setMargins(0, 0, 0, 0);
                param.setGravity(Gravity.CENTER);
                param.columnSpec = GridLayout.spec(c);
                param.rowSpec = GridLayout.spec(l);
                iv.setLayoutParams(param);
                myLayout.addView(iv);
            }
        }
        setContentView(myLayout);
    }

    /**
     * Retourne un nombre aléatoire entre min et max.
     * @param min
     * @param max
     * @return entier aléatoire
     */
    private int randomInto(int min, int max) {
        return (int) Math.round(Math.random() * (max - min)) + min;
    }

    /**
     * Retourne l'icon n de res/drawable.
     * @param n
     * @return id
     */
    private int getDrawableN(int n) {
        int id = getResources().getIdentifier("visage_" + n,"drawable", getPackageName());
        return id;
    }

    /**
     * Retourne la hauteur de la barre de notification
     * @return taille de la barre de notification
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}
