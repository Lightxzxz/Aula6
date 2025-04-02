package com.example.aula6;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class QuartaTela extends AppCompatActivity {

    private EditText editNome, editCpf, editDataNascimento, editTelefone, editCelular, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quarta_tela);

        // Inicializa views
        editNome = findViewById(R.id.editNome);
        editCpf = findViewById(R.id.editCpf);
        editDataNascimento = findViewById(R.id.editDataNascimento);
        editTelefone = findViewById(R.id.editTelefone);
        editCelular = findViewById(R.id.editCelular);
        editEmail = findViewById(R.id.editEmail);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        // Configura date picker
        editDataNascimento.setOnClickListener(v -> showDatePickerDialog());

        // Configura botão enviar
        btnEnviar.setOnClickListener(v -> enviarDados());
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    month += 1;
                    String dataSelecionada = dayOfMonth + "/" + month + "/" + year;
                    editDataNascimento.setText(dataSelecionada);
                },
                ano, mes, dia);
        datePickerDialog.show();
    }

    private void enviarDados() {
        Intent intent = new Intent(this, QuintaTela.class);
        intent.putExtra("NOME", editNome.getText().toString());
        intent.putExtra("CPF", editCpf.getText().toString());
        intent.putExtra("DATA_NASCIMENTO", editDataNascimento.getText().toString());
        intent.putExtra("TELEFONE", editTelefone.getText().toString());
        intent.putExtra("CELULAR", editCelular.getText().toString());
        intent.putExtra("EMAIL", editEmail.getText().toString());
        startActivity(intent);
    }
}