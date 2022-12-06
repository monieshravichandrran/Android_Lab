package com.example.multithread;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView banner, coords, counter;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        coords = findViewById(R.id.coords);
        counter = findViewById(R.id.counter);
        submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countervalue = Integer.parseInt(counter.getText().toString());
                countervalue++;
                counter.setText(Integer.toString(countervalue));
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int i = 1;
                        while(i++<1000){
                            banner.animate().translationX(400f).setDuration(1200);
                            banner.animate().translationX(-400f).setDuration(1200);
                            coords.animate().translationX(400f).setDuration(1200);
                        }
                        while(i++<1000){
                            banner.animate().translationX(-400f).setDuration(1200);
                        }
                    }
                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int i = 1;
                        while(i++<1000) {
                            banner.animate().rotationXBy(45f).setDuration(1000);
                            coords.animate().rotationXBy(30f).setDuration(1000);

                        }
                    }
                });
            }
        }).start();
    }
}