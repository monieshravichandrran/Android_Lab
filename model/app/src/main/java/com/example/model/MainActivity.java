package com.example.model;

import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.SEND_SMS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.database.sqlite.*;
import android.telephony.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText item;
    Button add, view, delete, create, smsBtn;
    TextView output;
    SQLiteDatabase db;
    Cursor rs;
    SmsManager sms;
    //SdCard sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = (EditText) (findViewById(R.id.todolistitem));
        add = (Button) (findViewById(R.id.add));
        view = (Button) (findViewById(R.id.view));
        delete = (Button) (findViewById(R.id.delete));
        db = openOrCreateDatabase("db",MODE_PRIVATE,null);
        create = (Button)(findViewById(R.id.create));
        output = (TextView)(findViewById(R.id.output));
        smsBtn = (Button) (findViewById(R.id.smsBtn));

        ActivityCompat.requestPermissions(this,new String[]{READ_SMS,SEND_SMS,RECEIVE_SMS,READ_PHONE_STATE},1);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("DROP TABLE IF EXISTS TODOLIST;");
                db.execSQL("CREATE TABLE TODOLIST(TITLE CHAR(30));");
                Log.d("Event", "reached here");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO TODOLIST VALUES(?);",new String[]{item.getText().toString()});
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rs = db.rawQuery("SELECT * FROM TODOLIST;",null);
                String result = "";
                while(rs.moveToNext()) {
                    result += (rs.getString(0) + "\n");
                }
                if(result==""){
                    output.setText("No Records Found");
                }
                else{
                    try {
                        output.setText(result);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,Delete.class);
                startActivity(myIntent);
            }
        });

        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sms = SmsManager.getDefault();
                sms.sendTextMessage("11111",null,item.getText().toString(),null,null);
            }
        });
    }
}