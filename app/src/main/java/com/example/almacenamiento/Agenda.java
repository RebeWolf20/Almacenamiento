package com.example.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Agenda extends AppCompatActivity {

    private EditText Nombre, Apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        Nombre = findViewById(R.id.txt_nombre);
        Apellido = (EditText) findViewById(R.id.txt_apellido);
    }

    public void GuardarDatos(View view){
        String nombre = Nombre.getText().toString();
        String apellido = Apellido.getText().toString();
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(nombre, apellido);
        obj_editor.commit();
        Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_SHORT).show();
    }

    public void Buscar(View view){
        String nombre = Nombre.getText().toString();
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String apellido = preferences.getString(nombre, "");
        if (apellido.length()==0) {
            Toast.makeText(this, "No se encontro ningun registro", Toast.LENGTH_SHORT).show();
        }else{
            Apellido.setText(apellido);
        }
    }
}