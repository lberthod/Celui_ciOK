package com.example.kev.projetkevloic.View.home;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kev.projetkevloic.Database.OiseauDB;
import com.example.kev.projetkevloic.adapter.OiseauAdapter;
import com.example.kev.projetkevloic.R;
import com.example.kev.projetkevloic.View.add.addOiseau;
import com.example.kev.projetkevloic.object.Oiseau;
import com.example.kev.projetkevloic.View.show.show_oiseau;

import java.util.ArrayList;
import java.util.List;

public class HomeOiseaux extends AppCompatActivity {

    ListView mListView;
    OiseauDB oDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_oiseaux);
        oDB = new OiseauDB(this);

        mListView = (ListView) findViewById(R.id.listView);

        afficherListeOiseaux();
    }

    private void afficherListeOiseaux() {
        List<Oiseau> oiseaux = oDB.getAllOiseaux();

        OiseauAdapter adapter = new OiseauAdapter(HomeOiseaux.this, oiseaux);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View view, int position, long id) {
                Intent intent = new Intent(HomeOiseaux.this, show_oiseau.class);

                Oiseau ois = (Oiseau)arg0.getItemAtPosition(position);
                intent.putExtra("ID", ois.getId());
                Log.d("-1-----------",ois.getId()+"");
                intent.putExtra("NOM", ois.getNom());
                intent.putExtra("COLOR",ois.getColor());
                intent.putExtra("POIDS",ois.getPoids());
                intent.putExtra("TEXT",ois.getText());
                intent.putExtra("TAILLE",ois.getTaille());

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adddelete_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.AddButton:
                intent = new Intent(this, addOiseau.class);

                this.startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}