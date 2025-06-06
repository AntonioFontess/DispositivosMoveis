package com.example.habito1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome, etDescricao, etFrequencia, etCategoria;
    private Habito habito;
    private int posicao = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_cadastro);

        // Habilita botão "Up" na barra
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        etNome = findViewById(R.id.etNome);
        etDescricao = findViewById(R.id.etDescricao);
        etFrequencia = findViewById(R.id.etFrequencia);
        etCategoria = findViewById(R.id.etCategoria);

        // Edição
        Intent i = getIntent();
        if (i.hasExtra("habito")) {
            habito = (Habito) i.getSerializableExtra("habito");
            posicao = i.getIntExtra("posicao", -1);

            // Preenche os campos com os dados recebidos
            etNome.setText(habito.getNome());
            etDescricao.setText(habito.getDescricao());
            etFrequencia.setText(habito.getFrequencia());
            etCategoria.setText(habito.getCategoria());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    // Tratamento do menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_salvar) {
            salvar();
            return true;
        } else if (id == R.id.menu_limpar) {
            limparCampos();
            Toast.makeText(this, "Campos limpos", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void salvar() {
        String nome = etNome.getText().toString().trim();
        String descricao = etDescricao.getText().toString().trim();
        String frequencia = etFrequencia.getText().toString().trim();
        String categoria = etCategoria.getText().toString().trim();

        if (nome.isEmpty() || descricao.isEmpty() || frequencia.isEmpty() || categoria.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos antes de salvar", Toast.LENGTH_SHORT).show();
            return;
        }

        Habito novo = new Habito(nome, descricao, frequencia, categoria);
        Intent intent = new Intent();
        intent.putExtra("habito", novo);
        if (posicao != -1) {
            intent.putExtra("posicao", posicao);
        }
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    private void limparCampos() {
        etNome.setText("");
        etDescricao.setText("");
        etFrequencia.setText("");
        etCategoria.setText("");
    }
}
