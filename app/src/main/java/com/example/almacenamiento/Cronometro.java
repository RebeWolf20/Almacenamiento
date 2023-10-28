package com.example.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class Cronometro extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean running;
    private long pauseoffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() >= 60000){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(Cronometro.this, "Bing!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void StartChronometer(View view){
        if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime()-pauseoffset);
            chronometer.start();
            running = true;
        }
    }

    public void PauseChronometer(View view){
        if (running){
            chronometer.stop();
            pauseoffset = SystemClock.elapsedRealtime()-chronometer.getBase();
            running =false;
        }
    }

    public void StopChronometer(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset = 0;
    }
}