package com.example.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void SharePreferences(View view){
        Intent share = new Intent(this, SharePreferences.class);
        startActivity(share);
    }

    public void Agenda (View view){
        Intent Agenda = new Intent(this, Agenda.class);
        startActivity(Agenda);
    }

    public void BlockDeNotas(View view){
        Intent Block = new Intent(this, Block_de_notas.class);
        startActivity(Block);
    }

    public void IngreseNombre (View view){
        Intent nombre = new Intent(this, nombre1.class);
        startActivity(nombre);
    }

    public void Cronometro(View view){
        Intent cronometro = new Intent(this, Cronometro.class);
        startActivity(cronometro);
    }

    public void TimePicket(View view){
        Intent TimePicket = new Intent(this, TimePicket.class);
        startActivity(TimePicket);
    }
}