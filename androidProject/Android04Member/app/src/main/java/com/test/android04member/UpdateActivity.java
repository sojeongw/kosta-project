package com.test.android04member;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// 소스 파일을 받을 때 import가 되지 않아 오류가 날 때 uninstall 팝업이 뜬다면
/* 소스 파일 압축 푼 파일을 내 프로젝트에 그냥 집어넣는다.
*  제일 첫번째 해야 할 것은 build-rebuild project 누르고 clean project를 한다.
*  build apk를 누르면 새롭게 또 generate 해준다.
*  이렇게 해서 run 되면 깔끔한데 안 될 때가 있다.
*  mainActivity를 찾을 수 없다고 뜬다면 이름을 바꿨다가 돌아와서 다시 위의 세 가지를 반복한다. */


public class UpdateActivity extends AppCompatActivity {
    int deleteCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        final SQLiteDatabase mDatabase =
                openOrCreateDatabase("member.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);


        // Intent intent = new 하면 넘겨준 값을 받지 못 하고 새롭게 만들어버리니까 안 된다.
        Intent intent = getIntent();
        // 모든 액티비티가 이 intent를 획득할 수 있고 intent가 담고 있는 정보에 접근 가능하다.
        Log.i("testLog", intent.getStringExtra("info"));
        // id를 키로 하는 값을 가져오겠다

//        String id = intent.getStringExtra("id").split(":")[0];
//        String pw = intent.getStringExtra("id").split(":")[1];
//        String name = intent.getStringExtra("id").split(":")[2];
//        String tel = intent.getStringExtra("id").split(":")[3];

        // 모범 답안
        String[] temp = intent.getStringExtra("info").split(":");

        final TextView et_num = (TextView) findViewById(R.id.et_num);
        et_num.setText(temp[0]);
        final EditText et_id = (EditText) findViewById(R.id.et_id);
        et_id.setText(temp[1]);
        final EditText et_pw = (EditText) findViewById(R.id.et_pw);
        et_pw.setText(temp[2]);
        final EditText et_name = (EditText) findViewById(R.id.et_name);
        et_name.setText(temp[3]);
        final EditText et_tel = (EditText) findViewById(R.id.et_tel);
        et_tel.setText(temp[4]);

        Button btn_select = (Button) findViewById(R.id.btn_select);
        Button btn_updateOK = (Button) findViewById(R.id.btn_updateOK);
        final Button btn_deleteOK = (Button) findViewById(R.id.btn_deleteOK);

//        Bundle bundle = intent.getExtras();
//        Log.i("testLog", bundle.getString("num"));
//        Log.i("testLog", bundle.getString("id"));
//        Log.i("testLog", bundle.getString("pw"));
//        Log.i("testLog", bundle.getString("name"));
//        Log.i("testLog", bundle.getString("tel"));

        btn_updateOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("log", "btn_updateOK");

                ContentValues values = new ContentValues();
                values.put("id", et_id.getText().toString());
                values.put("pw", et_pw.getText().toString());
                values.put("name", et_name.getText().toString());
                values.put("tel", et_tel.getText().toString());
                int updateCount = mDatabase.update("member", values, "num=?", new String[]{et_num.getText().toString()});

                if (updateCount > 0) {
                    // 성공하면 select로 가라
                    Toast.makeText(getApplicationContext(), "update suceeded", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "update failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("log", "btn_select");
                Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_deleteOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

              /*  AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
                // 여기서 this는 Activity의 this

                // 여기서 부터는 알림창의 속성 설정
                builder.setTitle("Alert!")        // 제목 설정
                        .setMessage("삭제하시겠습니까?")        // 메세지 설정
                        .setCancelable(false)        // 뒤로 버튼 클릭시 취소 가능 설정
                        .setPositiveButton("확인", new DialogInterface.OnClickListener(){
                            // 확인 버튼 클릭시 설정
                            public void onClick(DialogInterface dialog, int whichButton) {

                                finish();
                                deleteCount = mDatabase.delete("member", "num=?", new String[]{et_num.getText().toString()});
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
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            // 취소 버튼 클릭시 설정
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.cancel();
                            }
                        });

                AlertDialog dialog = builder.create();    // 알림창 객체 생성
                dialog.show();    // 알림창 띄우기*/

                LayoutInflater factory = LayoutInflater.from(UpdateActivity.this);
                final View textEntryView = factory.inflate(R.layout.alert_dialog_text_entry, null);
                return new android.app.AlertDialog.Builder(AlertDialogSamples.this)
                        .setIconAttribute(android.R.attr.alertDialogIcon)
                        .setTitle(R.string.alert_dialog_text_entry)
                        .setView(textEntryView)
                        .setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                        /* User clicked OK so do some stuff */
                            }
                        })
                        .setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                        /* User clicked cancel so do some stuff */
                            }
                        })
                        .create();







            }
        });


    }

}
