package com.example.aula6;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuintaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quinta_tela);

        TextView txtDados = findViewById(R.id.txtDados);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String dados = "Dados Cadastrados:\n\n" +
                    "Nome: " + extras.getString("NOME") + "\n" +
                    "CPF: " + extras.getString("CPF") + "\n" +
                    "Data Nasc.: " + extras.getString("DATA_NASCIMENTO") + "\n" +
                    "Telefone: " + extras.getString("TELEFONE") + "\n" +
                    "Celular: " + extras.getString("CELULAR") + "\n" +
                    "E-mail: " + extras.getString("EMAIL");

            txtDados.setText(dados);
        }
    }
}