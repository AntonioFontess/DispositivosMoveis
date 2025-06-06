package com.example.habito1;

import android.view.MenuItem;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radioGroup = findViewById(R.id.radioGroup);

        SharedPreferences prefs = getSharedPreferences("config", MODE_PRIVATE);
        String ordem = prefs.getString("ordenacao", "nome");

        if (ordem.equals("nome")) {
            radioGroup.check(R.id.radioNome);
        } else {
            radioGroup.check(R.id.radioCategoria);
        }

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            String novaOrdem = (checkedId == R.id.radioNome) ? "nome" : "categoria";
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("ordenacao", novaOrdem);
            editor.apply();
            Toast.makeText(this, getString(R.string.msg_config_salva), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
