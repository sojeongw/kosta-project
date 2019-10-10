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

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        // DB
        final SQLiteDatabase mDatabase =
                openOrCreateDatabase("board.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        Button btn_insertOK = (Button) findViewById(R.id.btn_insertOK);
        Button btn_select = (Button) findViewById(R.id.btn_select);

        final TextView et_num = (TextView) findViewById(R.id.et_num);
        final EditText et_title = (EditText) findViewById(R.id.et_title);
        final EditText et_content = (EditText) findViewById(R.id.et_content);
        final EditText et_writer = (EditText) findViewById(R.id.et_writer);
        final EditText et_regDate = (EditText) findViewById(R.id.et_regDate);

        // insert
        btn_insertOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog","btn_insertOK");
                Log.i("testLog", et_num.getText().toString());
                Log.i("testLog", et_title.getText().toString());
                Log.i("testLog", et_content.getText().toString());
                Log.i("testLog", et_writer.getText().toString());

                ContentValues values = new ContentValues();
                values.put("writer",et_writer.getText().toString());
                values.put("title",et_title.getText().toString());
                values.put("content",et_content.getText().toString());


                long rowNum = mDatabase.insert("board",null,values);
                if(rowNum>0){
                    Toast.makeText(getApplicationContext(), "insert suceeded", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "insert failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //select
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog","btn_select");
                Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



    }   // end of oncreate
}   // end of class
