package com.example.a1rn19is005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.a1rn19is005.databinding.ActivityPgm5Binding;

public class pgm5 extends AppCompatActivity {

    ActivityPgm5Binding binding;
    int counter = 0;
    boolean running=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPgm5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.start.setOnClickListener(view -> click(0));
        binding.stop.setOnClickListener(view -> click(1));


    }

    void click(int n) {
        if(n==0){
            counter=0;
            running=true;
            new MyCounter().start();
        }
        else if(n==1){
            running=false;
        }
    }

    Handler handler = new Handler(){
      public void handleMessage(Message m){
          binding.counter.setText(String.valueOf(m.what));
      }
    };

    class MyCounter extends Thread
    {
        public void run()
        {
            while(running)
            {
                counter++;
                handler.sendEmptyMessage(counter);
                try { Thread.sleep(1000);
                }
                catch(Exception e) { }
            }
        }
    }

}