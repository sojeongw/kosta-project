package com.test.android07gridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BigImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image);

        String[] info = new String[ImageAdapter.imgs.length];
        for(int i=0; i<info.length; i++){
            info[i] = "dog info : " + i;
        }

        ImageView img_big = (ImageView) findViewById(R.id.img_big);
        TextView txt_info = (TextView) findViewById(R.id.txt_info);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        Log.i("log", position+"");      // 0은 아무 것도 없을 때 기본값

//        img_big.setImageResource(R.drawable.sample_0);
//        txt_info.setText("aaa");

        // 내가 클릭한 이미지는 다 imageAdaptor에 들어가있다. 그럼 이 객체를 생성해서 imgs로 접근해야됨.
        // 그 imgs 배열이 private로 되어있어서 안 된다면 static으로 선언한다.
        img_big.setImageResource(ImageAdapter.imgs[position]);
        txt_info.setText(info[position]);


    }
}
