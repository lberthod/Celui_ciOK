package com.example.kev.projetkevloic.View.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kev.projetkevloic.Database.OrnithoDB;
import com.example.kev.projetkevloic.adapter.OrniAdapter;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.add.addOrni;
import com.example.kev.projetkevloic.object.Ornithologue;
import com.example.kev.projetkevloic.View.show.show_ornitho;

import java.util.ArrayList;
import java.util.List;

public class HomeOrnithologue extends AppCompatActivity {

    ListView mListView;
    OrnithoDB rDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ornithologue);
        rDB = new OrnithoDB(this);

        mListView = (ListView) findViewById(R.id.listView);

        afficherListeOrni();
    }



    private void afficherListeOrni() {
        List<Ornithologue> ornis = rDB.getAllOrnithos();

        OrniAdapter adapter = new OrniAdapter(HomeOrnithologue.this, ornis);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View view, int position, long id) {
                Intent intent = new Intent(HomeOrnithologue.this, show_ornitho.class);
                Ornithologue orn = (Ornithologue) arg0.getItemAtPosition(position);
                intent.putExtra("username", orn.getUsername());
                intent.putExtra("age",orn.getAge());
                intent.putExtra("canton",orn.getCanton());
                intent.putExtra("id" , orn.getId());
                intent.putExtra("password", orn.getPassword());

                startActivity(intent);
            }
        });
    }

}



