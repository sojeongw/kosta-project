package com.test.android05board;

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
                openOrCreateDatabase("board.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);



        /////// button
        Button btn_insert = (Button) findViewById(R.id.btn_insert);

        // insert
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog","btn_insert");
                Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        /////// listView
        ListView lv = (ListView) findViewById(R.id.lv);

        // 데이터 넣기
        final ArrayList<String> datas = new ArrayList<>();
        /*for(int i=0; i<30; i++){
            datas.add((i+1)+":writer"+(i+1)+":title"+(i+1)+":content"+(i+1)+":2017/09/13");
        }*/
        Cursor c = mDatabase.query("board",null,null,null,null,null,"num desc");
        c.moveToFirst();
        while(!c.isAfterLast()){
            Log.i("testLog",""+c.getString(c.getColumnIndex("num")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",""+c.getString(c.getColumnIndex("writer")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",""+c.getString(c.getColumnIndex("title")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",""+c.getString(c.getColumnIndex("content")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",""+c.getString(c.getColumnIndex("regDate")));  // num 칼럼의 index를 알려줘
            datas.add(c.getString(c.getColumnIndex("num"))+":"+c.getString(c.getColumnIndex("writer"))
                    +":"+c.getString(c.getColumnIndex("title"))+":"+c.getString(c.getColumnIndex("content"))
                    +":"+c.getString(c.getColumnIndex("regDate")));
            c.moveToNext(); // 다음 행으로 가

        }

        // 레이아웃
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, datas));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("testLog","lv");
                Log.i("testLog",datas.get(position));

                // 메시지 출력
                Toast.makeText(getApplicationContext(), datas.get(position),
                        Toast.LENGTH_SHORT).show();

                // update로 보내기
                Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
                // 창 순서
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 데이터 전송
                intent.putExtra("info", datas.get(position));
                // 실행
                startActivity(intent) ;
            }
        });




    }   // end of onCreate
}   // end of class
