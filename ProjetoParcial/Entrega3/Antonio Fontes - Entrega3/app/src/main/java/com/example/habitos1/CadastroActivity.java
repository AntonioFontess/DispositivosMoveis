package com.example.habitos1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_cadastro);

        // Configuração da ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Novo Hábito");
        }

        EditText etNome = findViewById(R.id.etNome);
        EditText etDescricao = findViewById(R.id.etDescricao);
        EditText etFrequencia = findViewById(R.id.etFrequencia);
        EditText etCategoria = findViewById(R.id.etCategoria);

        Button btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(v -> {
            String nome = etNome.getText().toString().trim();
            String descricao = etDescricao.getText().toString().trim();
            String frequencia = etFrequencia.getText().toString().trim();
            String categoria = etCategoria.getText().toString().trim();

            if(validarDados(nome, descricao, frequencia, categoria)) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("NOME", nome);
                resultIntent.putExtra("DESCRICAO", descricao);
                resultIntent.putExtra("FREQUENCIA", frequencia);
                resultIntent.putExtra("CATEGORIA", categoria);

                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validarDados(String... campos) {
        for(String campo : campos) {
            if(campo.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        setResult(RESULT_CANCELED);
        finish();
        return true;
    }
}