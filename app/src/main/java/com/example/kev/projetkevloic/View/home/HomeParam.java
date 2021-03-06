package com.example.kev.projetkevloic.View.home;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kev.projetkevloic.R;

import java.util.Locale;

public class HomeParam extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_param);
    }
        //Button pour passer en FR

            public void changeToFR(View v)
            {
                String languageToLoad  = "fr";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getResources().updateConfiguration(config,v.getResources().getDisplayMetrics());

                Intent intent = new Intent(HomeParam.this, HomeParam.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        //Button pour passer en ALL

            public void changeToALL(View v)
            {
                String languageToLoad  = "de";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getResources().updateConfiguration(config,v.getResources().getDisplayMetrics());

                Intent intent = new Intent(HomeParam.this, HomeParam.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        //Button pour passer en ENG

            public void changeToEN(View v)
            {
                String languageToLoad  = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getResources().updateConfiguration(config,v.getResources().getDisplayMetrics());

                Intent intent = new Intent(HomeParam.this, HomeParam.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

    }

