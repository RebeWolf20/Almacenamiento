package com.example.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class nombre1 extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre1);

        et1 = (EditText)findViewById(R.id.et_nombre);
    }

    public void Enviar(View v){
        String nombre = et1.getText().toString();
        if (nombre.length() == 0){
            Toast.makeText(this, "DEBES INGRESAR UN NOMBRE", Toast.LENGTH_SHORT).show();
        }

        if (nombre.length() != 0){
            Toast.makeText(this, "GRACIAS", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, nombre2.class);
            i.putExtra("dato", et1.getText().toString()); startActivity(i);
        }
    }

    public void Menu (View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}