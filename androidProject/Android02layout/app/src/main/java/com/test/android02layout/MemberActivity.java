package com.test.android02layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

public class MemberActivity extends AppCompatActivity {
    EditText et_id;
    EditText et_pw;
    EditText et_name;
    EditText et_tel;
    Button btn_insertOK;

    // mainActivity를 만들면 onCreate가 제일 먼저 생성된다
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 한 번 보여줘
         setContentView(R.layout.member_insert);
        // 다른 테이블을 메인에 보여주고 싶으면
        // setContentView(R.layout.main);

        // 이 아래로 코딩을 시작한다
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_tel = (EditText) findViewById(R.id.et_tel);
        btn_insertOK = (Button) findViewById(R.id.btn_insertOK);
//         view인데 editText 타입으로 캐스팅 필요. 상위에 있는 걸 하위에
//         넣을 때는 자동 캐스팅 되지만 하위를 상위에 넣을 때는 필요하다.


         Log.i("testLog", btn_insertOK.getText().toString());

        btn_insertOK.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("testLog", et_id.getText().toString());
                Log.i("testLog", et_pw.getText().toString());
                Log.i("testLog", et_name.getText().toString());
                Log.i("testLog", et_tel.getText().toString());
            }
        });




    }
}
