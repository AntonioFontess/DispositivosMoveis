package com.example.habito1;

import com.example.habito1.model.Habito;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.habito1.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class CadastroRegistroActivity extends AppCompatActivity {

    private Spinner spinnerHabitos;
    private Button btnSelecionarData;
    private TextView tvDataSelecionada;
    private CheckBox checkConcluido;

    private List<Habito> listaHabitos;
    private LocalDate dataSelecionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerHabitos = findViewById(R.id.spinnerHabitos);
        btnSelecionarData = findViewById(R.id.btnSelecionarData);
        tvDataSelecionada = findViewById(R.id.tvDataSelecionada);
        checkConcluido = findViewById(R.id.checkConcluido);

        AppDatabase db = AppDatabase.getInstance(this);
        listaHabitos = db.habitoDao().getAll();

        ArrayAdapter<Habito> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaHabitos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHabitos.setAdapter(adapter);

        btnSelecionarData.setOnClickListener(v -> abrirDatePicker());
    }

    private void abrirDatePicker() {
        Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            dataSelecionada = LocalDate.of(year, month + 1, dayOfMonth);
            tvDataSelecionada.setText("Data: " + dataSelecionada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }, ano, mes, dia);
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_salvar) {
            salvarRegistro();
            return true;
        } else if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void salvarRegistro() {
        if (dataSelecionada == null) {
            Toast.makeText(this, "Selecione uma data", Toast.LENGTH_SHORT).show();
            return;
        }

        Habito habitoSelecionado = (Habito) spinnerHabitos.getSelectedItem();
        boolean status = checkConcluido.isChecked();

        RegistroHabito registro = new RegistroHabito(habitoSelecionado.getId(), dataSelecionada, status);
        AppDatabase.getInstance(this).registroHabitoDao().insert(registro);

        Toast.makeText(this, "Registro salvo com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }
}
