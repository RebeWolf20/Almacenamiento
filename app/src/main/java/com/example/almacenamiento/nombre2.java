package com.example.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class nombre2 extends AppCompatActivity {

    private TextView tv1, tv2;
    RatingBar ratingBar;
    Button calificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre2);

        tv1 = findViewById(R.id.txt_Bienvenido);
        String Dato = getIntent().getStringExtra("dato");
        tv1.setText("Bienvenido " + Dato);
        ratingBar = findViewById(R.id.ratingBar);
        calificar = findViewById(R.id.btn_Calificar);

        calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), s+"Start", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Menu(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void Regresar(View view){
        Intent regresar = new Intent(this, nombre1.class);
        startActivity(regresar);
    }
}