package com.example.habitos1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicia diretamente a ListaHabitosActivity
        Intent intent = new Intent(this, ListaHabitosActivity.class);
        startActivity(intent);
        finish();
    }
}