package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.*;

import android.view.View;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button create,insert,retrieve,delete;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = (Button)(findViewById(R.id.create));
        insert = (Button)(findViewById(R.id.insert));
        retrieve = (Button)(findViewById(R.id.retrieve));
        delete = (Button)(findViewById(R.id.delete));
        db = openOrCreateDatabase("db",MODE_PRIVATE,null);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("DROP TABLE IF EXISTS PERSON;");
                db.execSQL("CREATE TABLE PERSON(Name CHAR(30), Phone CHAR(30), Email CHAR(30))");
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Insert.class);
                startActivity(myIntent);
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Retrive.class);
                startActivity(myIntent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Delete.class);
                startActivity(myIntent);
            }
        });
    }
}