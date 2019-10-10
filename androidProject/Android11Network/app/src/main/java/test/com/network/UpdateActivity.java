package test.com.network;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        final SQLiteDatabase mDatabase =
                openOrCreateDatabase("board.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        Button btn_updateOK = (Button) findViewById(R.id.btn_updateOK);
        Button btn_deleteOK = (Button) findViewById(R.id.btn_deleteOK);
        Button btn_select = (Button) findViewById(R.id.btn_select);

        // info 가져오기
        Intent intent = getIntent();
        Log.i("testLog", intent.getStringExtra("info"));
        // 자르기
        String[] temp = intent.getStringExtra("info").split(":");

        // info를 update 페이지 포맷에 넣기
        final TextView et_num = (TextView) findViewById(R.id.et_num);
        et_num.setText(temp[0]);
        final EditText et_writer = (EditText)findViewById(R.id.et_writer);
        et_writer.setText(temp[1]);
        final EditText et_title = (EditText)findViewById(R.id.et_title);
        et_title.setText(temp[2]);
        final EditText et_content = (EditText)findViewById(R.id.et_content);
        et_content.setText(temp[3]);

        // update
        btn_updateOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog","btn_insert");

                // query
                ContentValues values = new ContentValues();
                values.put("writer",et_writer.getText().toString());
                values.put("title",et_title.getText().toString());
                values.put("content",et_content.getText().toString());
                int updateCount = mDatabase.update("board",values,"num=?",new String[]{et_num.getText().toString()});

                if(updateCount>0){
                    // 성공하면 select로 가라
                    Toast.makeText(getApplicationContext(), "update suceeded", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // select
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog","btn_select");
                Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        // delete
        btn_deleteOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deleteCount = mDatabase.delete("board", "num=?", new String[]{et_num.getText().toString()});

                if (deleteCount > 0) {
                    // 성공하면 select로 가라
                    Toast.makeText(getApplicationContext(), "delete suceeded", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "delete failed", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }   // end of oncreate
}   // end of class
