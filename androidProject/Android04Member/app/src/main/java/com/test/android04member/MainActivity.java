package com.test.android04member;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sql 연결하기
        /* (String name, int mode, CursorFactory factory)
         name은 db 이름, create인지 open인지, factory는 잘 쓰지 않으니 null */
        SQLiteDatabase mDatabase =
                openOrCreateDatabase("member.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        // 각 activity마다 열어줘야 한다.

        // create table
        /* mDatabase.execSQL("create table member()");
         테이블 만들고 종료했다 또 열면 같은 걸 다시 만들게 되므로 아래를 추가해준다.*/
        mDatabase.execSQL("create table if not exists member(num integer primary key autoincrement," +
                "id text, pw text, name text, tel text)");



        Button btn_insert = (Button) findViewById(R.id.btn_insert);
        Button btn_select = (Button) findViewById(R.id.btn_select);

        btn_insert.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("log","insert_btn");
                // startActivity(new Intent(getApplicationContext(),InsertActivity.class));
                // 같은 의미
                Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
                // 동일한 액티비티가 떴을 때 밑에 있는 걸 지우고 top으로 올려주는 기능
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                // 이렇게 하면 추가 세팅을 해줄 수 있다는 장점이 있다.

                /*activity의 task : 차곡차곡 쌓여서 종료시 순서대로
                단점 - 같은 걸 다시 띄워도 아래에는 계속 쌓여있음.
                화면을 왔다갔다 하게되면 지금까지 누른 횟수만큼 뒤로 가야한다.
                이걸 관리해주는 메소드가 intent.addFlags*/

                /*map이라고 생각하고 key값으로 불러올 수 있는게
                * Bundle, putExtra ...etc
                * 즉 intent로 넘겨줘 하려면 intent.putExtra 해서 넘기면 된다.*/
            }
        });

        btn_select.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("log","btn_select");
                Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });


    }
}
