package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.database.sqlite.*;

import android.os.Bundle;

public class Delete extends AppCompatActivity {
    SQLiteDatabase db;
    Button delete;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delete = (Button)(findViewById(R.id.delete));
        phone = (EditText) (findViewById(R.id.phone));
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.d("sql: ", "delreach ");
                    db = openOrCreateDatabase("db", MODE_PRIVATE, null);
                    db.execSQL("DELETE FROM PERSON WHERE PHONE = ?",new String[]{phone.getText().toString()});
                    Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_SHORT).show();
                }catch(SQLException e){
                    e.printStackTrace();
                    Log.d("sql", "delerror: ");
                }
            }
        });
    }
}