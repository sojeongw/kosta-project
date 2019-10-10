package com.test.android06events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] qs = new String[]{"1. who is sojeong's boyfriend?","2. what's sojeong's real name?","3. what's sojeong's family name?",
    "4. mola","5. test"};
    String[] as = new String[]{"bogeom","princess","gondu"};
    String[][] es = new String[][]{{"1. bogeom","2. kangjoon","3. seungho"},
                 {"1. wang","2. princess","3. kim"},
                 {"1. lee","2. wang","3. gondu"},
            {"1. test","2. test","3. test"},
            {"1. test2","2. test2","3. test2"}};

    // 지금 몇 번 문제인지 세팅하는 변수
    int currentQ = 0;
    int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        final TextView txt_msg = (TextView) findViewById(R.id.txt_msg);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, qs));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("log","spinner "+qs[position]);

                // position에 해당하는 문제로 세팅
                currentQ = position;

                // 각 문제에 맞는 checkBox 세팅
                checkBox1.setText(es[position][0]);
                checkBox2.setText(es[position][1]);
                checkBox3.setText(es[position][2]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.i("log", checkBox1.getText().toString());
                    Log.i("log", checkBox1.getText().toString().split(". ")[0]);
                    Log.i("log", qs[currentQ].toString());

                    if(qs[currentQ].toString().split(". ")[0].equals("1")){
                        txt_msg.setText("정답입니다!ㅇ▽ㅇ/");
                        ++step;
                        ratingBar.setRating(step);
                        checkBox3.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("2")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox1.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("3")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox1.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("4")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox1.setChecked(false);
                    } else{
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox1.setChecked(false);
                    }

                    //Toast.makeText(getApplicationContext(),"정답입니다!ㅇ▽ㅇ/",Toast.LENGTH_SHORT).show();
                }

            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.i("log", checkBox2.getText().toString());
                    Log.i("log", checkBox2.getText().toString().split(". ")[0]);
                    Log.i("log", qs[currentQ].toString());

                    if(qs[currentQ].toString().split(". ")[0].equals("1")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        checkBox2.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("2")){
                        txt_msg.setText("정답입니다!ㅇ▽ㅇ/");
                        ++step;
                        ratingBar.setRating(step);
                        checkBox3.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("3")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox1.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("4")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox1.setChecked(false);
                    } else{
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox2.setChecked(false);
                    }
                    //Toast.makeText(getApplicationContext(),"틀렸습니다!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.i("log", checkBox3.getText().toString());
                    Log.i("log", checkBox3.getText().toString().split(". ")[0]);
                    Log.i("log", "qs" + qs[currentQ].toString());

                    if(qs[currentQ].toString().split(". ")[0].equals("1")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox3.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("2")){
                        txt_msg.setText("틀렸습니다!ㅇ▽ㅇ/");
                        --step;
                        ratingBar.setRating(step);
                        checkBox3.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("3")){
                        txt_msg.setText("정답입니다!ㅇ▽ㅇ/");
                        ++step;
                        ratingBar.setRating(step);
                        checkBox3.setChecked(false);
                    } else if(qs[currentQ].toString().split(". ")[0].equals("4")){
                        txt_msg.setText("정답입니다!ㅇ▽ㅇ/");
                        ++step;
                        ratingBar.setRating(step);
                        checkBox3.setChecked(false);
                    } else{
                        txt_msg.setText("정답입니다!ㅇ▽ㅇ/");
                        ++step;
                        ratingBar.setRating(step);
                        checkBox3.setChecked(false);
                    }
                    //Toast.makeText(getApplicationContext(),"틀렸습니다!",Toast.LENGTH_SHORT).show();
                }
            }
        });



        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("log", String.valueOf(ratingBar.getRating()));
                //rating = (float) step;

            }
        });




    }   // end of Oncreate
}   // end of class
