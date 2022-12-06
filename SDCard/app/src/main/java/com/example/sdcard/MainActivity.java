package com.example.sdcard;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest.permission.*;
import android.view.View;
import android.widget.*;
import java.io.*;
import java.util.Scanner;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText fileName, fileContent;
    Button readbtn, writebtn;
    File SDCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = findViewById(R.id.filename);
        fileContent = findViewById(R.id.filecontent);
        readbtn = findViewById(R.id.button2);
        writebtn = findViewById(R.id.button);
        SDCard = getExternalFilesDir("SDdirectory");
        ActivityCompat.requestPermissions(this,new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE},1);
        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileWriter fw = new FileWriter(SDCard.getAbsolutePath() + "/" + fileContent.getText().toString().trim(),false);
                    fw.write(fileContent.getText().toString());
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File file = new File(SDCard,fileName.getText().toString().trim());
                    Scanner r = new Scanner(file);
                    r.useDelimiter("\\Z");
                    fileContent.setText(r.next());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
