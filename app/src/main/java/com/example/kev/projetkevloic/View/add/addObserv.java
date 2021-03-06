package com.example.kev.projetkevloic.View.add;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.kev.projetkevloic.Database.ObserverDB;
import com.example.kev.projetkevloic.Database.OiseauDB;
import com.example.kev.projetkevloic.Database.OrnithoDB;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.home.HomeObservations;
import com.example.kev.projetkevloic.View.home.HomeOiseaux;

import java.util.ArrayList;

/**
 * Created by Kev on 26.04.2017.
 */

public class addObserv extends AppCompatActivity {

    Button butOk;
    ObserverDB bDB = new ObserverDB(this);
    OiseauDB oDB = new OiseauDB(this);
    OrnithoDB rDB = new OrnithoDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_observ);

        ArrayList<String> oiseauName = oDB.getAllOiseauxName();
        Spinner spinnerOiseau = (Spinner) findViewById(R.id.editText);

        ArrayAdapter<String> adapteroiseauName = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, oiseauName);
        spinnerOiseau.setAdapter(adapteroiseauName);

        butOk = (Button) findViewById(R.id.button5) ;

        butOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tOiseau , tOrnitho, Ttext;

                Spinner mySpinner= (Spinner) findViewById(R.id.editText);
                String oiseau = mySpinner.getSelectedItem().toString();

                Ttext = (EditText)   findViewById(R.id.editText2);

                Log.d("------" ,oiseau);
                Log.d("---------", Ttext.getText().toString());

                bDB.createObservation(oDB.getIdByName(oiseau),1,Ttext.getText().toString());

                Intent intent = new Intent(addObserv.this , HomeObservations.class);

                startActivity(intent);
            }
        });
    }

}
