package com.example.habitos;


import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroHabitoActivity extends AppCompatActivity {


    private EditText editTextNomeHabito;
    private Spinner spinnerFrequencia;
    private RadioGroup radioGroupTipo;
    private CheckBox checkBoxDiario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_habito);

        editTextNomeHabito = findViewById(R.id.editTextNomeHabito);
        spinnerFrequencia = findViewById(R.id.spinnerFrequencia);
        radioGroupTipo = findViewById(R.id.radioGroupTipo);
        checkBoxDiario = findViewById(R.id.checkBoxDiario);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.opcoes_frequencia,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrequencia.setAdapter(adapter);

        findViewById(R.id.buttonLimpar).setOnClickListener(view -> limparFormulario());
        findViewById(R.id.buttonSalvar).setOnClickListener(view -> salvarFormulario());
    }

    private void limparFormulario() {
        editTextNomeHabito.setText("");
        spinnerFrequencia.setSelection(0);
        radioGroupTipo.clearCheck();
        checkBoxDiario.setChecked(false);
        editTextNomeHabito.requestFocus();

        Toast.makeText(this, "Formulário limpo com sucesso!", Toast.LENGTH_SHORT).show();
    }

    private void salvarFormulario() {
        String nome = editTextNomeHabito.getText().toString().trim();
        if (nome.isEmpty()) {
            Toast.makeText(this, "Preencha o nome do hábito!", Toast.LENGTH_SHORT).show();
            editTextNomeHabito.requestFocus();
            return;
        }

        int radioId = radioGroupTipo.getCheckedRadioButtonId();
        if (radioId == -1) {
            Toast.makeText(this, "Selecione o tipo do hábito!", Toast.LENGTH_SHORT).show();
            return;
        }

        String tipoHabito = ((RadioButton) findViewById(radioId)).getText().toString();
        String frequencia = spinnerFrequencia.getSelectedItem().toString();
        boolean isDiario = checkBoxDiario.isChecked();

        String resumo = "Hábito: " + nome + "\nFrequência: " + frequencia + "\nTipo: " + tipoHabito + "\nDiário: " + (isDiario ? "Sim" : "Não");
        Toast.makeText(this, resumo, Toast.LENGTH_LONG).show();
    }
}
