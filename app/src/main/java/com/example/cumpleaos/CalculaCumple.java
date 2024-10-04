package com.example.cumpleaos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cumpleaos.databinding.ActivityCalculaCumpleBinding;
import com.example.cumpleaos.databinding.ActivityMainBinding;

import java.time.LocalDate;

public class CalculaCumple extends AppCompatActivity {
    ActivityCalculaCumpleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculaCumpleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int vueltas = intent.getIntExtra("vueltasAlSol",0);

        binding.vueltas.setText("Has dado " +  vueltas + " vueltas al sol");
        binding.volver.setOnClickListener(view -> {
            Intent volverIntent = new Intent(CalculaCumple.this, MainActivity.class);
            startActivity(volverIntent);
        });

    }



}





