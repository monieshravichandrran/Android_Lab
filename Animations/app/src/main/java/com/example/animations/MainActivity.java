package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button color,rotate,scale;
    ImageView img;
    Paint paint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color = (Button)(findViewById(R.id.color));
        rotate = (Button)(findViewById(R.id.rotate));
        scale = (Button)(findViewById(R.id.scale));
        img = (ImageView)(findViewById(R.id.image));
        paint = new Paint();
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = Bitmap.createBitmap(100,100,Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                paint.setColor(Color.BLUE);
                canvas.drawRect(20,20,90,60,paint);
                img.setImageBitmap(bitmap);
            }
        });
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setScaleX(0.5f);
                img.setScaleY(0.5f);
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setRotationX(30f);
            }
        });
    }
}