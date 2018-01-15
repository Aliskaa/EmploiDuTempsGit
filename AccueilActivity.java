package com.kevin.emploidutemps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Calendar;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final Button BSettings = findViewById(R.id.BSettings);
        BSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, Settings.class);
                startActivity(intent);
            }
        });

        LinearLayout scroll = findViewById(R.id.scrollDays);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View wizard = getLayoutInflater().inflate(R.layout.day, scroll, false);

        Calendar calendar = Calendar.getInstance();
        int daysMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < daysMonth; i++) {
//            Log.d("Appli", "day: " + i+1);
            wizard.setId(100 + i);

            scroll.addView(wizard);
        }


    }
}
