package com.example.kev.projetkevloic.View.show;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kev.projetkevloic.Database.ObserverDB;
import com.example.kev.projetkevloic.Database.OiseauDB;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.edit.edit_observ;
import com.example.kev.projetkevloic.View.home.HomeObservations;
import com.example.kev.projetkevloic.View.home.HomeOiseaux;

/**
 * Created by Kev on 26.04.2017.
 */

public class show_observ extends AppCompatActivity  {

    ObserverDB bDB = new ObserverDB(this);

    private int id , orni, oiseau;
    private String text, orniN, oiseauN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_observ);

    //Get the intent
    Intent intent = getIntent();

    //Extract the strings
     orni = intent.getIntExtra("orni",0);
     oiseau = intent.getIntExtra("oiseau",0);
     text = intent.getStringExtra("text");
     orniN = intent.getStringExtra("orniName");
     oiseauN = intent.getStringExtra("oiseauName");
     id = intent.getIntExtra("id",0);
        Log.d("-------------", id+"");




    //Set the values
    TextView txtLblOrni = (TextView) findViewById(R.id.textView1);
    txtLblOrni.setText("Orni : ");

    TextView txtLblOiseau = (TextView) findViewById(R.id.textView2);
    txtLblOiseau.setText("Oiseau : ");

    TextView txtLblText = (TextView) findViewById(R.id.textView3);
        txtLblText.setText("Text : ");




    TextView txtOrni = (TextView) findViewById(R.id.textView4);
        txtOrni.setText(orniN);

    TextView txtOiseau = (TextView) findViewById(R.id.textView5);
        txtOiseau.setText(oiseauN);

    TextView txtText = (TextView) findViewById(R.id.textView6);
        txtText.setText(text);


}


    public void Retour (View view) {
                finish();
    }

    public void modifier (View view) {

        // CONTROLER ICI


        Intent intent = new Intent(show_observ.this, edit_observ.class);

        TextView txtOrni = (TextView) findViewById(R.id.textView4);
        String orni = txtOrni.getText().toString();

        TextView txtOiseau = (TextView) findViewById(R.id.textView5);
        String oiseau = txtOiseau.getText().toString();

        TextView txtText = (TextView) findViewById(R.id.textView6);
        String text = txtText.getText().toString();


        intent.putExtra("orni", orni);
        intent.putExtra("oiseau",oiseau);
        intent.putExtra("text",text);
        intent.putExtra("id", id );
        intent.putExtra("oiseauName" , oiseauN );
        intent.putExtra("orniName" , orniN);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.butDelete:
                intent = new Intent(this, HomeObservations.class);
                bDB.deleteObservation(id);
                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

}

