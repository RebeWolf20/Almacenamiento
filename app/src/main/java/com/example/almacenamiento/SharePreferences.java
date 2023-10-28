package com.example.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.SharedPreferences;

public class SharePreferences extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);

        et1=findViewById(R.id.txt_email);
        SharedPreferences preferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        et1.setText(preferences.getString("mail", ""));
    }

    public void Guardar(View view){
        SharedPreferences preferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferences.edit();
        Obj_editor.putString("mail", et1.getText().toString());
        Obj_editor.commit();
        finish();
    }
}