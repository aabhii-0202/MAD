package com.example.a1rn19is005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1rn19is005.databinding.ActivityLoginBinding;

public class login extends AppCompatActivity {
    ActivityLoginBinding binding;
    String user;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("SignupDetails", Context.MODE_PRIVATE);
        user = sharedPref.getString("UserName","");
        pass = sharedPref.getString("Password","");
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Login","User: "+user+" Pass: "+pass);
                next();
            }
        });

    }

    private void next() {
        EditText e1 = findViewById(R.id.lusername);
        EditText e2 = findViewById(R.id.lpassword);

        String u = e1.getText().toString();
        String p = e2.getText().toString();

        Log.i("Login",u+" "+p);

        if(u.trim().length()<1){
            binding.lusername.setError("Enter Username");
        }
        else if(p.trim().length()<1){
            binding.lpassword.setError("Enter Password");
        }else{
            if(!user.equals(u)){
                Toast.makeText(this, "Incorrect User Name", Toast.LENGTH_SHORT).show();
            }
            else if(!pass.equals(p)){
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
            }else{
                startActivity(new Intent(this,LoginSuccessful.class));
                finish();
            }
        }
    }
}