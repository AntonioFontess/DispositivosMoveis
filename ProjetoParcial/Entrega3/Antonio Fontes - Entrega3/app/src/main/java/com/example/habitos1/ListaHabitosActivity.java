package com.example.habitos1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ListaHabitosActivity extends AppCompatActivity {
    private static final int CADASTRO_REQUEST_CODE = 1;
    private ArrayList<Habito> habitos;
    private HabitoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_habitos);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Meus Hábitos");
        }

        habitos = new ArrayList<>();

        // Configura ListView
        ListView listView = findViewById(R.id.listViewHabitos);
        adapter = new HabitoAdapter(this, habitos);
        listView.setAdapter(adapter);

        // Botão Adicionar
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(v -> {
            Intent intent = new Intent(this, CadastroActivity.class);
            startActivityForResult(intent, CADASTRO_REQUEST_CODE);
        });

        // Botão Sobre
        Button btnSobre = findViewById(R.id.btnSobre);
        btnSobre.setOnClickListener(v -> {
            Intent intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Habito h = habitos.get(position);
            String mensagem = h.getNome() + " (" + h.getCategoria() + ")";
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CADASTRO_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String nome = data.getStringExtra("NOME");
            String descricao = data.getStringExtra("DESCRICAO");
            String frequencia = data.getStringExtra("FREQUENCIA");
            String categoria = data.getStringExtra("CATEGORIA");

            Habito novoHabito = new Habito(nome, descricao, frequencia, categoria);
            habitos.add(novoHabito);
            adapter.notifyDataSetChanged();
        }
    }
}