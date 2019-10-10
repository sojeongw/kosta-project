package com.test.android03student;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        final SQLiteDatabase mDatabase =
                openOrCreateDatabase("student.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);


        Button btn_insertOK = (Button) findViewById(R.id.btn_updateOK);
        Button btn_select = (Button) findViewById(R.id.btn_select);

        final EditText txt_num = (EditText) findViewById(R.id.txt_num);
        final EditText txt_name = (EditText) findViewById(R.id.txt_name);
        final EditText txt_kor = (EditText) findViewById(R.id.txt_kor);
        final EditText txt_eng = (EditText) findViewById(R.id.txt_eng);
        final EditText txt_math = (EditText) findViewById(R.id.txt_math);

        btn_insertOK.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("log","btn_insertOK");

                Log.i("log", txt_name.getText().toString());
                Log.i("log", txt_kor.getText().toString());
                Log.i("log", txt_eng.getText().toString());
                Log.i("log", txt_math.getText().toString());

                ContentValues values = new ContentValues();
                values.put("name",txt_name.getText().toString());
                values.put("kor",txt_kor.getText().toString());
                values.put("eng",txt_eng.getText().toString());
                values.put("math",txt_math.getText().toString());

                // insert는 long타입임
                long rowNum = mDatabase.insert("student",null,values);
                if(rowNum>0){
                    Toast.makeText(getApplicationContext(), "insert suceeded", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "insert failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_select.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("log","btn_select");

                Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



    }

}
