package com.example.a1rn19is005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.a1rn19is005.databinding.ActivityPgm7Binding;

import java.util.Locale;

public class pgm7 extends AppCompatActivity {

    ActivityPgm7Binding binding;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPgm7Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        textToSpeech = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    Toast.makeText(pgm7.this, "Success", Toast.LENGTH_SHORT).show();
                    textToSpeech.setLanguage(Locale.UK);
                    Log.i("t2s","Success");
                }
            }
        });

        binding.btn.setOnClickListener(view -> {
            String str = binding.text.getText().toString();
            if(str.length()>0){
                textToSpeech.speak(str,TextToSpeech.QUEUE_FLUSH,null);
            }else{
                Log.i("t2s","LEngth 0");
            }
        });
    }
}