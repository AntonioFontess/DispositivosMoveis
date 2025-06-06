package com.example.habito1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ListaHabitosActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Habito> listaHabitos;
    private HabitoAdapter adapter;

    private static final int REQUEST_CADASTRO = 1;
    private static final int REQUEST_EDICAO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_habitos);

        listView = findViewById(R.id.listViewHabitos);
        listaHabitos = new ArrayList<>();

        // Hábito fictício para teste visual
        listaHabitos.add(new Habito("Estudar Java", "Estudar 30 minutos", "Diariamente", "Estudo"));

        adapter = new HabitoAdapter(this, listaHabitos);
        listView.setAdapter(adapter);

        // Menu contextual ao pressionar item
        registerForContextMenu(listView);
    }

    // Menu superior (Adicionar / Sobre)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    // Ações do menu superior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_adicionar) {
            Intent intent = new Intent(this, CadastroActivity.class);
            startActivityForResult(intent, REQUEST_CADASTRO);
            return true;
        } else if (item.getItemId() == R.id.menu_sobre) {
            startActivity(new Intent(this, SobreActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Criação do menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
    }

    // Ações do menu contextual
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Habito habito = listaHabitos.get(info.position);

        if (item.getItemId() == R.id.menu_editar) {
            Intent intent = new Intent(this, CadastroActivity.class);
            intent.putExtra("habito", habito);
            intent.putExtra("posicao", info.position);
            startActivityForResult(intent, REQUEST_EDICAO);
            return true;
        } else if (item.getItemId() == R.id.menu_excluir) {
            listaHabitos.remove(info.position);
            adapter.notifyDataSetChanged();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    // Trata retorno do CadastroActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && data != null) {
            Habito habito = (Habito) data.getSerializableExtra("habito");

            if (requestCode == REQUEST_CADASTRO) {
                listaHabitos.add(habito);
            } else if (requestCode == REQUEST_EDICAO) {
                int pos = data.getIntExtra("posicao", -1);
                if (pos != -1) {
                    listaHabitos.set(pos, habito);
                }
            }

            adapter.notifyDataSetChanged();
        }
    }
}
