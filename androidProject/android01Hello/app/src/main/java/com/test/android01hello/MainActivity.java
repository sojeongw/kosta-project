package com.test.android01hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // UI를 보여주는 최종 지점
    }
}

// UI의 고유 사이즈는 텍스트의 길이에 의해 정해진다.
// ui의 xml 내에서 id 설정하기 : (@+id) + UI의 id
// 텍스트 사이즈는 sp, 도형은 dp
