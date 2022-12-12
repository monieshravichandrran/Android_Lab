package com.example.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.database.sqlite.*;

import android.os.Bundle;

public class Delete extends AppCompatActivity {

    EditText name;
    Button delete, goBack;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        name = (EditText) (findViewById(R.id.name));
        delete = (Button) (findViewById(R.id.button));
        db = openOrCreateDatabase("db",MODE_PRIVATE,null);
        goBack = (Button) (findViewById(R.id.goback));

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("DELETE FROM TODOLIST WHERE TITLE = ?",new String[]{name.getText().toString()});
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Delete.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

    }
}