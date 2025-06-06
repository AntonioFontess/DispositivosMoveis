package com.example.habito1;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.habito1.model.AppDatabase;
import com.example.habito1.model.Habito;
import com.example.habito1.model.RegistroHabito;

import java.util.List;

public class ListaRegistrosActivity extends AppCompatActivity {

    private TextView tvTituloHabito;
    private ListView listView;
    private RegistroAdapter adapter;
    private Habito habitoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_registros);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTituloHabito = findViewById(R.id.tvTituloHabito);
        listView = findViewById(R.id.listViewRegistros);

        if (getIntent().hasExtra("habito")) {
            habitoSelecionado = (Habito) getIntent().getSerializableExtra("habito");
            tvTituloHabito.setText("Registros de: " + habitoSelecionado.getNome());

            List<RegistroHabito> registros = AppDatabase.getInstance(this)
                    .registroHabitoDao()
                    .findByHabito(habitoSelecionado.getId());

            adapter = new RegistroAdapter(this, registros);
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Nenhum hábito selecionado", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
