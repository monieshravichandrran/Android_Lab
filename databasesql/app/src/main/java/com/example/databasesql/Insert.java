package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.database.sqlite.*;

import android.os.Bundle;

public class Insert extends AppCompatActivity {
    SQLiteDatabase db;
    EditText name,email,phone;
    Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("sql: ", "reached here: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        db = openOrCreateDatabase("db",MODE_PRIVATE,null);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        insert = findViewById(R.id.insertbtn);
        Log.d("sql: ", "start out: ");
        insert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               Log.d("sql: ", "start: ");
                try {
                    db.execSQL("INSERT INTO PERSON VALUES(?,?,?)", new String[]{name.getText().toString(), phone.getText().toString(), email.getText().toString()});
                    Toast.makeText(getApplicationContext(),"Inserted Succesfully", Toast.LENGTH_SHORT).show();
                    Log.d("sql:", "inserted ");
                }
                catch(SQLException e){
                    e.printStackTrace();
                    Log.d("sql:", "error ");
                }
            }
        });
    }
}