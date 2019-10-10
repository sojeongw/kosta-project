package com.test.android04member;

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
                openOrCreateDatabase("member.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        final EditText et_id = (EditText)findViewById(R.id.et_id);
        final EditText et_pw = (EditText)findViewById(R.id.et_pw);
        final EditText et_name = (EditText)findViewById(R.id.et_name);
        final EditText et_tel = (EditText)findViewById(R.id.et_tel);

        Button btn_select = (Button) findViewById(R.id.btn_select);
        Button btn_insertOK = (Button) findViewById(R.id.btn_insertOK);

        btn_insertOK.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("log","btn_insertOK");
                Log.i("log", et_id.getText().toString());
                Log.i("log", et_pw.getText().toString());
                Log.i("log", et_name.getText().toString());
                Log.i("log", et_tel.getText().toString());

                ContentValues values = new ContentValues();
                values.put("id",et_id.getText().toString());
                values.put("pw",et_pw.getText().toString());
                values.put("name",et_name.getText().toString());
                values.put("tel",et_tel.getText().toString());
//                mDatabase.insert("member",null,values);
//                mDatabase.execSQL("insert into member(id,pw,name,tel) values()"),
//                        new String[]{et_id.getText().toString(),et_pw.getText().toString(),
//                                et_name.getText().toString(),et_tel.getText().toString()};
                long rowNum = mDatabase.insert("member",null,values);
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

        btn_select.setOnClickListener(new View.OnClickListener() {
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
