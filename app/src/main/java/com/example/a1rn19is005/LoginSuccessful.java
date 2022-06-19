package com.example.a1rn19is005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginSuccessful extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successful);

        TextView t = findViewById(R.id.logout);
        t.setOnClickListener(view -> {
            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("SignupDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("UserName","");
            editor.putString("Password","");
            editor.putBoolean("User",false);
            editor.apply();
            finish();
        });
    }
}