package com.example.cumpleaos;



import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cumpleaos.databinding.ActivityMainBinding;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.fecha.setFocusable(false);
        binding.fecha.setClickable(true);


    //para que se muestre el calendario al hacer click
        binding.fecha.setOnClickListener(view -> mostrarCalendario());
        binding.calcula.setOnClickListener(view -> {
            String fechaNacimiento = binding.fecha.getText().toString();

            int vueltasSol= calcularVueltas(fechaNacimiento);
            Intent intent = new Intent(MainActivity.this, CalculaCumple.class);
            intent.putExtra("vueltasAlSol", vueltasSol); // Pasar las vueltas al sol

            // Iniciar la otra actividad
            startActivity(intent);
        });


    }
    private void mostrarCalendario(){
        LocalDate fech = LocalDate.now();
        int anio = fech.getYear();
        int mes = fech.getMonthValue()-1;
        int dia = fech.getDayOfMonth();

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,dateSetListener,anio,mes,dia);

        datePickerDialog.show();
    }



    DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
            binding.fecha.setText((dia + "/" + (mes+1) + "/") + anio);
        }
    };

    private int calcularVueltas(String fechaNacimiento){
        String[] dividir= fechaNacimiento.split("/");
        int dia = Integer.parseInt(dividir[0]);
        int mes= Integer.parseInt(dividir[1]);
        int anio= Integer.parseInt(dividir[2]);

        LocalDate nacimiento= LocalDate.of(anio,mes,dia);
        //sacar la fecha actual para calcular las vueltas
        LocalDate hoy= LocalDate.now();
        int edad= hoy.getYear() - nacimiento.getYear();

        if (hoy.getDayOfYear() < nacimiento.getDayOfYear()){
            edad--;
        }

       return edad;

    }


}