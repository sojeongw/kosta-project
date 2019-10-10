package com.test.android03student;

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

        // sql 연결하기
        /* (String name, int mode, CursorFactory factory)
         name은 db 이름, create인지 open인지, factory는 잘 쓰지 않으니 null */
        SQLiteDatabase mDatabase =
                openOrCreateDatabase("student.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // 각 activity마다 열어줘야 한다.

        // create table
        /* mDatabase.execSQL("create table member()");
         테이블 만들고 종료했다 또 열면 같은 걸 다시 만들게 되므로 아래를 추가해준다.*/
        mDatabase.execSQL("create table if not exists student(num integer primary key autoincrement," +
                "name text, kor integer, eng integer, math integer)");



        Button btn_insert = (Button) findViewById(R.id.btn_updateOK);
        Button btn_select = (Button) findViewById(R.id.btn_select);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("log", "btn_insert");
                Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("log", "btn_select");
                Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });



    }

}
