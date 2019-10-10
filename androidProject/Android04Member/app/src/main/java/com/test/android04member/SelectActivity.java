package com.test.android04member;

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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        final SQLiteDatabase mDatabase =
                openOrCreateDatabase("member.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        Button btn_insert = (Button) findViewById(R.id.btn_insert);

        btn_insert.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InsertActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        ListView lv = (ListView) findViewById(R.id.lv);

        // 배열 입력 가능
        // String[] datas = new String[]{"aaa","bbb","ccc","aaa","bbb","ccc","aaa","bbb","ccc","aaa","bbb","ccc"};
        // List 입력 가능
        final ArrayList<String> datas = new ArrayList<>();
        //for(int i=0; i<30; i++){
           // datas.add("aaa" + i);
            //datas.add((i+1)+":admin"+(i+1)+":a2468:lee:02");
        //}
        /* 이제 mdatabase 쓸거니까 for문 주석처리*/

        // cursor 타입으로 불러온다.
        // order by 굳이 쓰지 않고 바로 num desc라고 할 수 있다.
        Cursor c = mDatabase.query("member",null,null,null,null,null,"num desc");
        c.moveToFirst();    // 일단 첫번째 행으로 가
        // 너가 마지막 행이 아니면 loop 돌아라
        while(!c.isAfterLast()){
            Log.i("testLog",""+c.getString(c.getColumnIndex("num")));  // num 칼럼의 index를 알려줘
            Log.i("testLog",""+c.getString(c.getColumnIndex("id")));  // num 칼럼의 index를 알려줘
            datas.add(c.getString(c.getColumnIndex("num"))+":"+c.getString(c.getColumnIndex("id"))
                    +":"+c.getString(c.getColumnIndex("pw"))+":"+c.getString(c.getColumnIndex("name"))
                    +":"+c.getString(c.getColumnIndex("tel")));
            c.moveToNext(); // 다음 행으로 가

        }

        /* 자기 자신도 context타입이기 때문에 쓸 수 있다.
         innerclass에서 쓰지 못 한 이유는 그 이너클래스만 this가 되기 때문이다.
         lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));
         만약 이 레이아웃이 별로라서 커스텀 하고 싶다면*/
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, datas));

        /* 여러 개 중에 하나만 선택할 때
         lv.setOnItemSelectedListener();
         그냥 클릭할 때
         lv.setOnItemSelectedListener();
         그냥 클릭할 때
         lv.setOnItemLongClickListener();*/

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("log", ""+datas.get(position));
                Toast.makeText(getApplicationContext(), datas.get(position),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),UpdateActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // 지금 보내고 싶은 값은 datas.get(position)
                // 정보를 줄 때는 매핑을 해야한다.
                intent.putExtra("info", datas.get(position));

                // 여러 값을 번들에 담을 수 있다
//                Bundle bundle = new Bundle();
//                bundle.putString("num","1");
//                bundle.putString("id","tester");
//                bundle.putString("pw","k456");
//                bundle.putString("name","park");
//                bundle.putString("tel","010");

//                intent.putExtras(bundle);
                startActivity(intent);


            }
        });



    }   // end onCreate()
}   // end class
