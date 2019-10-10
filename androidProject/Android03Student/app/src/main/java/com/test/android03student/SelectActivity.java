package com.test.android03student;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class SelectActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        final SQLiteDatabase mDatabase =
                openOrCreateDatabase("student.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);


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
//        for(int i=0; i<30; i++){
//            datas.add((i+1)+":kim"+":100:90:80");
//        }

        Cursor c = mDatabase.query("student",null,null,null,null,null,"num desc");
        c.moveToFirst();

        while(!c.isAfterLast()){
            Log.i("testLog",c.getString(c.getColumnIndex("num")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",c.getString(c.getColumnIndex("name")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",c.getString(c.getColumnIndex("kor")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",c.getString(c.getColumnIndex("eng")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",c.getString(c.getColumnIndex("math")));  // num 칼럼의 index를 알려줘
            datas.add(c.getString(c.getColumnIndex("num"))+":"+c.getString(c.getColumnIndex("name"))
                    +":"+c.getString(c.getColumnIndex("kor"))+":"+c.getString(c.getColumnIndex("eng"))
                    +":"+c.getString(c.getColumnIndex("math")));
            c.moveToNext(); // 다음 행으로 가

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

                intent.putExtra("info", datas.get(position));

                Bundle bundle = new Bundle();
                bundle.putString("num","1");
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
