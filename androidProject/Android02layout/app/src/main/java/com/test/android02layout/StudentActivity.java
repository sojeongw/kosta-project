package com.test.android02layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.util.Log;
import android.view.View;

public class StudentActivity extends AppCompatActivity {


    // mainActivity를 만들면 onCreate가 제일 먼저 생성된다
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 한 번 보여줘
         setContentView(R.layout.student_insert);

        final EditText st_name = (EditText) findViewById(R.id.st_name);
        final EditText st_kor = (EditText) findViewById(R.id.st_kor);
        final EditText st_eng = (EditText) findViewById(R.id.st_eng);
        final EditText st_math = (EditText) findViewById(R.id.st_math);
        final Button st_btn = (Button) findViewById(R.id.st_btn);

        st_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("testLog", st_name.getText().toString());
                Log.i("testLog", st_kor.getText().toString());
                Log.i("testLog", st_eng.getText().toString());
                Log.i("testLog", st_math.getText().toString());

                int k = Integer.parseInt(st_kor.getText().toString());
                int e = Integer.parseInt(st_eng.getText().toString());
                int m = Integer.parseInt(st_math.getText().toString());

                int total = k+e+m;
                double avg = (double) total/3;

                Log.i("testLog", String.valueOf(total));
                Log.i("testLog", String.valueOf(avg));
            }
        });


    }
}
