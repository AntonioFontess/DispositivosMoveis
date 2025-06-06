package com.example.habitos1;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ListaHabitosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_habitos);

        // Carrega dados dos recursos
        String[] nomes = getResources().getStringArray(R.array.habitos_nomes);
        String[] descricoes = getResources().getStringArray(R.array.habitos_descricoes);
        String[] frequencias = getResources().getStringArray(R.array.habitos_frequencias);
        String[] categorias = getResources().getStringArray(R.array.habitos_categorias);

        // Preenche lista
        ArrayList<Habito> habitos = new ArrayList<>();
        for (int i = 0; i < nomes.length; i++) {
            habitos.add(new Habito(
                    nomes[i],
                    descricoes[i],
                    frequencias[i],
                    categorias[i]
            ));
        }

        // Configura ListView
        ListView listView = findViewById(R.id.listViewHabitos);
        HabitoAdapter adapter = new HabitoAdapter(this, habitos);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            Habito h = habitos.get(position);
            String mensagem = h.getNome() + " (" + h.getCategoria() + ")";
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        });
    }
}