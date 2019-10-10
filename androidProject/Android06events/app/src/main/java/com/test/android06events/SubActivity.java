package com.test.android06events;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    String[] qs = new String[]{"who is sojeong's boyfriend?","what's sojeong's real name?","what's sojeong's family name?"};
    String[] as = new String[]{"bogeom","princess","gondu"};
    String[][] es = new String[][]{{"1. bogeom","2. kangjoon","3. seungho"},
                 {"1. wang","2. princess","3. kim"},
                 {"1. lee","2. wang","3. gondu"}};

    // 지금 몇 번 문제인지 세팅하는 변수
    int currentQ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        final TextView txt_msg = (TextView) findViewById(R.id.txt_msg);

        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, qs));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("log","spinner "+qs[position]);

                // position에 해당하는 문제로 세팅
                currentQ = position;

                // 각 문제에 맞는 checkBox 세팅
                radioButton1.setText(es[position][0]);
                radioButton2.setText(es[position][1]);
                radioButton3.setText(es[position][2]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.i("log", radioButton1.getText().toString());
                    Log.i("log", radioButton1.getText().toString().split(". ")[0]);

                    if(qs[currentQ].toString().split(". ")[0].equals("1")){
                        txt_msg.setText("정답입니다!ㅇ▽ㅇ/");
                    } else if(qs[currentQ].toString().split(". ")[1].equals("2")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                    } else{
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                    }
                    }

            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.i("log", radioButton2.getText().toString());
                    Log.i("log", radioButton2.getText().toString().split(". ")[0]);

                    if(qs[currentQ].toString().split(". ")[0].equals("1")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                    } else if(qs[currentQ].toString().split(". ")[0].equals("2")){
                        txt_msg.setText("정답입니다!ㅇ▽ㅇ/");
                    } else{
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                    }
                    }
            }
        });

        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.i("log", radioButton3.getText().toString());
                    Log.i("log", radioButton3.getText().toString().split(". ")[0]);
                    if(qs[currentQ].toString().split(". ")[0].equals("1")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                    } else if(qs[currentQ].toString().split(". ")[0].equals("2")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                    } else{
                        txt_msg.setText("정답입니다!ㅇ▽ㅇ/");
                    }
                }
            }
        });





    }   // end of Oncreate
}   // end of class
