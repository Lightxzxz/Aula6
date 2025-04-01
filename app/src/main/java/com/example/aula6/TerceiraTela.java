package com.example.aula6;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class TerceiraTela extends AppCompatActivity {
    private TextView data;
    private DatePickerDialog.OnDateSetListener datePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceira_tela);

        data = findViewById(R.id.data);

        datePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month +=1;
                String texto = dayOfMonth +"/"+month+"/"+year;
                data.setText(texto);
            }
        };

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                int mes = calendar.get(Calendar.MONTH);
                int ano = calendar.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(
                        TerceiraTela.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        datePicker,
                        ano,
                        mes,
                        dia
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
    }
}