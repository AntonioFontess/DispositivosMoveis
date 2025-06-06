package com.example.habito1;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        // exemplo de teste de ordenação
        listaHabitos.add(new Habito("Estudar Java", "Estudar 30 minutos", "Diariamente", "Estudo"));
        listaHabitos.add(new Habito("Ler", "Ler por 20 minutos", "Diariamente", "Leitura"));
        listaHabitos.add(new Habito("Correr", "Correr por 30 minutos", "Diariamente", "Exercício"));

        aplicarOrdenacaoSalva();

        adapter = new HabitoAdapter(this, listaHabitos);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_adicionar) {
            Intent intent = new Intent(this, CadastroActivity.class);
            startActivityForResult(intent, REQUEST_CADASTRO);
            return true;
        } else if (id == R.id.menu_sobre) {
            startActivity(new Intent(this, SobreActivity.class));
            return true;
        } else if (id == R.id.menu_config) {
            startActivity(new Intent(this, ConfigActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
    }

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
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.confirmar_exclusao)) // Ex: "Confirmação"
                    .setMessage(getString(R.string.deseja_excluir))   // Ex: "Deseja realmente excluir este hábito?"
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                        listaHabitos.remove(info.position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

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

            aplicarOrdenacaoSalva();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        aplicarOrdenacaoSalva();
        adapter.notifyDataSetChanged();
    }

    private void aplicarOrdenacaoSalva() {
        SharedPreferences prefs = getSharedPreferences("config", MODE_PRIVATE);
        String ordem = prefs.getString("ordenacao", "nome");

        if (ordem.equals("nome")) {
            Collections.sort(listaHabitos, Comparator.comparing(Habito::getNome));
        } else if (ordem.equals("categoria")) {
            Collections.sort(listaHabitos, Comparator.comparing(Habito::getCategoria));
        }
    }
}
