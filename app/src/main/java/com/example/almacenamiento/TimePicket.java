package com.example.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePicket extends AppCompatActivity {

    private TimePicker timePicker;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picket);

        timePicker = findViewById(R.id.TimePicker1);
        textView = findViewById(R.id.txt_hora);

        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) ->
                textView.setText(hourOfDay+":"+minute));
    }
}