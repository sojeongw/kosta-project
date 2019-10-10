package com.test.android02layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_id;
    EditText et_pw;
    EditText et_name;
    EditText et_tel;

    // mainActivity를 만들면 onCreate가 제일 먼저 생성된다
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 한 번 보여줘
         setContentView(R.layout.main);

        Button btn_student_insert = (Button) findViewById(R.id.btn_student_insert);
        Button btn_member_insert = (Button) findViewById(R.id.btn_member_insert);

        btn_student_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TestLog", "btn_student_insert");

                /* 가고 싶은 클래스를 명시해주는 법
                 new Context()로 하지 않는 이유는
                 계속 새로운 걸 생성하는 게 아니라
                 내가 지금 보고 있는 것을 의미하기 때문*/
                startActivity(new Intent(getApplicationContext(),StudentActivity.class));
            }
        });

        btn_member_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TestLog", "btn_member_insert");
                startActivity(new Intent(getApplicationContext(),MemberActivity.class));
            }
        });


    }
}
