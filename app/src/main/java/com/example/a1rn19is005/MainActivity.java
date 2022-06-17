package com.example.a1rn19is005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a1rn19is005.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.one.setOnClickListener(view -> startActivity(new Intent(context,pgm1.class)));
        binding.two.setOnClickListener(view -> startActivity(new Intent(context,SimpleCalculator.class)));
        binding.four.setOnClickListener(view -> startActivity(new Intent(context,pgm4.class)));

    }
}