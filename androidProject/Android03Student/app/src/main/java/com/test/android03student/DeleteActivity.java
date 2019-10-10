package com.test.android03student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        Button btn_insert = (Button) findViewById(R.id.btn_insert);

        btn_insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("log","btn_insert");
                Intent intent = new Intent(getApplicationContext(),InsertActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        // 데이터 array에 삽입
        final ArrayList<String> datas = new ArrayList<>();
        for(int i=0; i<30; i++){
            datas.add((i+1)+":kim"+":100:90:80");
        }

        // 레이아웃 세팅
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, datas));

        // ListView에 들어갈 내용
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("testLog", "test"+datas.get(position));
                Toast.makeText(getApplicationContext(), datas.get(position),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),UpdateActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // intent.putExtra("info", datas.get(position));

                Bundle bundle = new Bundle();
                bundle.putString("name","도더니");
                bundle.putString("kor","100");
                bundle.putString("eng","90");
                bundle.putString("math","50");

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }   // end of bundle

}
