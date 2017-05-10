package com.example.kev.projetkevloic.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.kev.projetkevloic.Database.ObserverDB;
import com.example.kev.projetkevloic.Database.OiseauDB;
import com.example.kev.projetkevloic.Database.OrnithoDB;
import com.example.kev.projetkevloic.View.home.HomeObservations;
import com.example.kev.projetkevloic.View.home.HomeOiseaux;
import com.example.kev.projetkevloic.View.home.HomeOrnithologue;
import com.example.kev.projetkevloic.View.home.HomeParam;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.object.Observation;
import com.example.kev.projetkevloic.object.Oiseau;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Création des trois connections à la BD
    OiseauDB oDB = new OiseauDB(this);
    OrnithoDB rDB = new OrnithoDB(this);
    ObserverDB bDB = new ObserverDB(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //methodes pour remplir ou vider les tables

        //deleteObservation();
        //deleteOiseau();
        //deleteOrnitho();
        //creationOiseau();
        //creationOrnitho();
        //creationObservations();


    }

    private void deleteOiseau() {
        for (int i = 0 ; i< 100 ; i++){
            oDB.deleteOiseau(i);
        }

    }

    private void deleteOrnitho() {
        for (int i = 0 ; i< 100 ; i++){
            rDB.deleteOrnitho(i);
        }
    }

    private void deleteObservation() {
        for (int i = 0 ; i< 100 ; i++){
            bDB.deleteObservation(i);
        }
    }


    //OpenX : méthode ouvrant les autres affichages
    public void OpenOiseaux (View view) {
        Intent intent = new Intent(this, HomeOiseaux.class);
        startActivity(intent);
    }
    public void OpenOrnithologue (View view) {

        Intent intent = new Intent(this, HomeOrnithologue.class);

        startActivity(intent);
    }
    public void OpenObservations (View view) {

        Intent intent = new Intent(this, HomeObservations.class);

        startActivity(intent);
    }
    public void OpenParam (View view) {

        Intent intent = new Intent(this, HomeParam.class);

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.butParam:
                intent = new Intent(this, HomeParam.class);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


    public void creationOiseau(){

        // inserting oiseaux
        oDB.createOiseau("Pigeon", " Bleu", "200g", "50cm", "Très belle oiseau");
        oDB.createOiseau("Perroquet", " Blanc", "330g", "30cm", "Très peetit oiseau");
        oDB.createOiseau("Moineau", " Jaune", "120g","40cm", "Très grand oiseau");
        oDB.createOiseau("Rouge-Gorge", " Vert", "111g","25cm", "Très moyen oiseau");

    }

    public void creationOrnitho(){

        // inserting ornitho
        rDB.createOrnitho("Loic","1234","23","Valais");
        rDB.createOrnitho("Paul","1234","25","Vaud");
        rDB.createOrnitho("Kevin","1234","21","Neuchatel");
        rDB.createOrnitho("Flavien","1234","23","Fribourgr");

    }

    public void creationObservations(){

        // inserting observations
        bDB.createObservation(1, 1,"Je crois l'avoir vu, deux males et un petit");
        bDB.createObservation(2, 2,"Il était mort au bord d'une route");
        bDB.createObservation(2, 2,"Il était vivant, j'avais faim");
        bDB.createObservation(3, 3,"Il faisait nuit, donc je sais pas");
        bDB.createObservation(1, 4,"Il miauler");

    }
}
