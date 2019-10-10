package com.test.android05board;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////// DB 연결
        SQLiteDatabase mDatabase =
                openOrCreateDatabase("board.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // create table
        mDatabase.execSQL("create table if not exists board(num integer primary key autoincrement," +
                "writer text, title text, content text, regDate date default CURRENT_DATE)");


        Button btn_insert = (Button) findViewById(R.id.btn_insert);
        Button btn_select = (Button) findViewById(R.id.btn_select);

        // insert
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog","btn_insert");
                Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
                startActivity(intent);
            }
        });

        //select
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog","btn_select");
                Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                startActivity(intent);
            }
        });



    }   // end of oncreate
}   // end of class
