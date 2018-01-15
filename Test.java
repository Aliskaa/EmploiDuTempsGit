package com.kevin.emploidutemps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.Calendar;

public class Test extends AppCompatActivity {

    private static final String EMPL_TPS = "EMPL_TPS";
    private static final String HORAIRE_A = "HORAIRE_A";
    private static final String HORAIRE_B = "HORAIRE_B";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        sharedPreferences = getBaseContext().getSharedPreferences(EMPL_TPS, Context.MODE_PRIVATE);
        Gson gson = new Gson();

        if (sharedPreferences.contains(HORAIRE_A) && sharedPreferences.contains(HORAIRE_B)) {

        } else {
            Calendar calander = Calendar.getInstance();
            int horaireA = calander.get(Calendar.HOUR_OF_DAY);

            sharedPreferences.edit()
                    .putString("user", gson.toJson(horaireA))
                    .apply();
        }
    }
}
