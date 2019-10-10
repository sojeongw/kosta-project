package com.test.android03student;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        final SQLiteDatabase mDatabase =
                openOrCreateDatabase("student.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        Intent intent = getIntent();
        Log.i("testLog", intent.getStringExtra("info"));

        String[] temp = intent.getStringExtra("info").split(":");

        final EditText txt_num = (EditText) findViewById(R.id.txt_num);
        txt_num.setText(temp[0]);
        final EditText txt_name = (EditText) findViewById(R.id.txt_name);
        txt_name.setText(temp[1]);
        final EditText txt_kor = (EditText)findViewById(R.id.txt_kor);
        txt_kor.setText(temp[2]);
        final EditText txt_eng = (EditText)findViewById(R.id.txt_eng);
        txt_eng.setText(temp[3]);
        final EditText txt_math = (EditText)findViewById(R.id.txt_math);
        txt_math.setText(temp[4]);


        Button btn_updateOK = (Button) findViewById(R.id.btn_updateOK);
        Button btn_select = (Button) findViewById(R.id.btn_select);
        Button btn_deleteOK = (Button) findViewById(R.id.btn_deleteOK);

        Bundle bundle = intent.getExtras();
        Log.i("testLog", bundle.getString("num"));
        Log.i("testLog", bundle.getString("name"));
        Log.i("testLog", bundle.getString("kor"));
        Log.i("testLog", bundle.getString("eng"));
        Log.i("testLog", bundle.getString("math"));

        btn_updateOK.setOnClickListener(new View.OnClickListener(){

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
                int updateCount = mDatabase.update("student",values,"num=?",new String[]{txt_num.getText().toString()});

                if(updateCount>0){
                    // 성공하면 select로 가라
                    Toast.makeText(getApplicationContext(), "update suceeded", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "update failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_deleteOK.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("log","btn_deleteOK");
                int deleteCount = mDatabase.delete("student", "num=?", new String[]{txt_num.getText().toString()});

                if (deleteCount > 0) {
                    // 성공하면 select로 가라
                    Toast.makeText(getApplicationContext(), "delete suceeded", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "delete failed", Toast.LENGTH_SHORT).show();
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
