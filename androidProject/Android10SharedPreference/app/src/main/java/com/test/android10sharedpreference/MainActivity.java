package com.test.android10sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("test",0);
        Log.i("test","**log : " + sp.toString());

        // 두번째 값은 값이 없다면 보낼 기본값.
        String user_name = sp.getString("user_name", "admin");
        Log.i("test", "**user_name : "+user_name);
        // 설정값은 그때그때 종료하기 보다는 주로 액티비티를 저장할 때 종료한다.
        // 완전 종료 onStop()이나 onPause()에 저장하게 된다.

        // admin 값을 editText에 넣는다
        editText = (EditText) findViewById(R.id.editText);
        editText.setText(user_name);

        ///// 미션
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setChecked(false);
        SharedPreferences sp2 = getSharedPreferences("test",0);
        Log.i("test","**log : " + sp2.toString());
        boolean check = sp2.getBoolean("checked",false);
        Log.i("test","**log : " + check);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sp = getSharedPreferences("test",0);

        // 종료되었을 때 저장한다
        SharedPreferences.Editor ed = sp.edit();

        /* 매핑
        ed.putString("user_name","aaaa");
        종료 혹은 홈화면으로 이동
        ed.commit();*/

        // 내가 입력한 값을 갖고 오라고 하고 싶다면 editText에서 가져와야 하니까 영역이 달라서 가져올 수가 없다.
        // editText를 전역으로 올린다.
        ed.putString("user_name", editText.getText().toString());
        ed.commit();


        ////// 미션

        SharedPreferences sp2 = getSharedPreferences("test",0);
        SharedPreferences.Editor ed2 = sp2.edit();
        if(checkBox.isChecked()) {
            ed2.putBoolean("checked", true);
            ed2.commit();
        }else{
            ed2.putBoolean("checked", false);
            ed2.commit();
        }

    }
}
