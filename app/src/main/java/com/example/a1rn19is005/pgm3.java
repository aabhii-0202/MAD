package com.example.a1rn19is005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.a1rn19is005.databinding.ActivityPgm3Binding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pgm3 extends AppCompatActivity {

    ActivityPgm3Binding binding;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPgm3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPref = getApplicationContext().getSharedPreferences("SignupDetails",Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        boolean user = sharedPref.getBoolean("User",false);
        if(user){
            startActivity(new Intent(this,login.class));
            finish();
        }

        binding.btn.setOnClickListener(view -> {
            String u = binding.username.getText().toString();
            String p = binding.password.getText().toString();

            if(u.trim().length()<1){
                binding.username.setError("Enter Username");
            }
            else if(p.trim().length()<1){
                binding.password.setError("Enter Password");
            }else{
                if(validate(p)) signup(u,p);
                else binding.password.setError("Error validating password");
            }
        });
    }

    private boolean validate(String pass) {
        return true;
//        String regularExpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
//        Pattern pattern=Pattern.compile(regularExpression);
//        Matcher matcher=pattern.matcher(pass);
//        return matcher.matches();
    }

    private void signup(String user, String pass) {


        editor.putString("UserName",user);
        editor.putString("Password",pass);
        editor.putBoolean("User",true);
        editor.apply();
        startActivity(new Intent(this,login.class));
        finish();
    }
}