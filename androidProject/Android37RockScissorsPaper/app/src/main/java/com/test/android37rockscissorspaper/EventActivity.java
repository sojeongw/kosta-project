package com.test.android37rockscissorspaper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class EventActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        textView = (TextView) findViewById(R.id.textView);

        Random random = new Random();
        int a = random.nextInt(2);
        if(a==0){
            textView.setText("가위");
        } else if(a==1){
            textView.setText("바위");
        } else  textView.setText("보");

        Log.i("log", "random"+a);
    }


}
