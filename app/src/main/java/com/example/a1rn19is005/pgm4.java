package com.example.a1rn19is005;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class pgm4 extends AppCompatActivity {

    int i=0;
    boolean running;
    int[] imageArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm4);


        findViewById(R.id.button).setOnClickListener(view -> {
            imageArray= new int[]{
                    R.drawable.image1,
                    R.drawable.image2,
                    R.drawable.image3,
                    R.drawable.image4,
                    R.drawable.image5,
                    R.drawable.image6,
                    R.drawable.image7,
                    R.drawable.image8,
                    R.drawable.image9,
                    R.drawable.image10
            };
            if(!running){
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try{
                            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                            if(i==10) i=1;

                            wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), imageArray[i]));
                            findViewById(R.id.pgm4bg).setBackground(getDrawable(imageArray[i]));
                            i++;
                            Log.i("Tag","Walpaper no"+i);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },10,3000);
                running= true;
            }
        });
    }
}