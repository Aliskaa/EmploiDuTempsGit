package com.kevin.emploidutemps;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by kevin on 06/01/2018.
 */

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        final Button buttonA = findViewById(R.id.buttonA);
        final TextView textA = findViewById(R.id.textA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerStart = new TimePickerDialog(Settings.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        textA.setText(String.format("%02d", selectedHour) + ":" + String.format("%02d", selectedMinute));
                    }

                }, hour, minute, true);
                timePickerStart.setTitle("Heure de début");
                timePickerStart.show();

                TimePickerDialog timePickerEnd = new TimePickerDialog(Settings.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        textA.setText(textA.getText() + " - " + String.format("%02d", selectedHour) + ":" + String.format("%02d", selectedMinute));
                    }

                }, hour, minute, true);
                timePickerEnd.setTitle("Heure de fin");
                timePickerEnd.show();
            }
        });

    }
}
