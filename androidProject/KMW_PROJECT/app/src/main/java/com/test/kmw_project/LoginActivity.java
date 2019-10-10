package com.test.kmw_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText et_id = (EditText) findViewById(R.id.et_id);
        EditText et_pw = (EditText) findViewById(R.id.et_pw);

        Button btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);  // 인텐트 생성
                LoginActivity.this.startActivity(loginIntent); // 버튼을 클릭하면 login 인텐트 실행
            }
        });



    }
}
