package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.*;
import android.widget.*;

import android.os.Bundle;

public class Retrive extends AppCompatActivity {

    Button submit;
    TextView result;
    SQLiteDatabase db;
    Cursor rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);
        db = openOrCreateDatabase("db",MODE_PRIVATE,null);
        result = findViewById(R.id.result);
        submit = findViewById(R.id.retrieve);
        try {
            rs = db.rawQuery("SELECT * FROM PERSON;", null);
            String msg = "";
            while (rs.moveToNext()) {
                msg = msg + rs.getString(0) + ", " + rs.getString(1) + ", " + rs.getString(2) + "\n";
            }
            if(msg==""){
                result.setText("NO RECORDS FOUND");
            }
            else{
                result.setText(msg);
            }
            Toast.makeText(getApplicationContext(),"Retrived Successfully",Toast.LENGTH_SHORT).show();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}