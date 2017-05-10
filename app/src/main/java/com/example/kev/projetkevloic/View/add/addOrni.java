package com.example.kev.projetkevloic.View.add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kev.projetkevloic.Database.OrnithoDB;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.edit.edit_ornitho;
import com.example.kev.projetkevloic.View.home.HomeOrnithologue;
import com.example.kev.projetkevloic.object.Ornithologue;

public class addOrni extends AppCompatActivity {

    Button bOK;
    OrnithoDB rDB = new OrnithoDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_orni);

        bOK = (Button) findViewById(R.id.button5) ;

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tusername , tpassword, tage ,tcanton;

                tusername =  (EditText)  findViewById(R.id.editText6);
                tpassword =  (EditText)  findViewById(R.id.editText);
                tage =  (EditText)  findViewById(R.id.editText2);
                tcanton =  (EditText)  findViewById(R.id.editText4);


                rDB.createOrnitho(tusername.getText().toString(),
                        tpassword.getText().toString() ,
                        tage.getText().toString(),
                        tcanton.getText().toString());

                Intent intent = new Intent(addOrni.this , HomeOrnithologue.class);

                startActivity(intent);
            }
        });
    }
}
