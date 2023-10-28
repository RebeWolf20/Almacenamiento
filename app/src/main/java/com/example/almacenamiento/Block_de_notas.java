package com.example.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Block_de_notas extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_de_notas);

        et1 = findViewById(R.id.txt_Notas);
        String archivos [] = fileList();
        if (ArchivoExicte(archivos, "notas.txt")){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String Linea = br.readLine();
                String NotasCompletas = "";
                while (Linea != null){
                    NotasCompletas = NotasCompletas + Linea+ "\n";
                    Linea = br.readLine();
                }
                br.close();
                archivo.close();
                et1.setText(NotasCompletas);
            }catch (IOException e){ }
        }
    }

    private boolean ArchivoExicte (String archivo [], String NombreArchivo){
        for (int i = 0; i<archivo.length; i++)
            if (NombreArchivo.equals(archivo[i])) return true; return false;
    }

    public  void GuardarNotas(View view){
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE));
            archivo.write(et1.getText().toString());
            archivo.flush();
            archivo.close();
        }catch (IOException e){ }

        Toast.makeText(this, "Notas Guardadas", Toast.LENGTH_SHORT).show();
        finish();
    }
}