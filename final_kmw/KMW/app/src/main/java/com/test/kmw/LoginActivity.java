package com.test.kmw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    final Handler loginHandler = new Handler();
    EditText et_id;
    EditText et_pw;
    Button btn_login;
    String id = null;
    String pw = null;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        btn_login = (Button) findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MainActivity.class);  // 인텐트 생성

                new Thread(){
                    @Override
                    public void run() {
                        login();

                        loginHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                if (id.equals(et_id.getText().toString()) && pw.equals(et_pw.getText().toString())) {
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);

                                } else {
                                    showDialog(1);
                                }
                            }
                        });
                    }
                }.start();
            }
        });


    }// end onCreate

    public void login(){
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL("http://192.168.0.121:8090/kmw/AndroidLoginSelectOne.do?id="+et_id.getText().toString());
            conn = (HttpURLConnection)url.openConnection();
            Log.i("LoginActivity","getContentType>>"+conn.getContentType());
            Log.i("LoginActivity","getResponseMessage>>"+conn.getResponseMessage());
            Log.i("LoginActivity","getResponseCode>>"+conn.getResponseCode());
            Log.i("LoginActivity","getContentLength>>"+conn.getContentLength());

            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = null;
            StringBuilder sb = new StringBuilder();

            if((str=br.readLine())!=null){
                Log.i("LoginActivity-Str","str insert"+str);
                sb.append(str);
                Log.i("LoginActivity-Str","str after insert"+str);
            } else {
                sb.append("");
            }
            Log.i("LoginActivity",sb.toString());

            if(sb.toString() != "") {
                final String txtJSON = sb.toString();
                try {
                    JSONObject obj = new JSONObject(txtJSON);

                    id = obj.getString("id");
                    pw = obj.getString("pw");

                    Log.i("LoginActivity", id + ":" + pw);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                id = "-";
                pw = "-";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }{
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                conn.disconnect();
            }

        }

    }
    @Override
    protected android.app.Dialog onCreateDialog(int id) {
        switch (id) {
            case 1:
                return new AlertDialog.Builder(LoginActivity.this, AlertDialog.THEME_HOLO_LIGHT)
                        .setIconAttribute(android.R.attr.alertDialogIcon)
                        .setTitle(R.string.alert_dialog_two_buttons_title)

                        .setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.cancel();
                        /* User clicked Cancel so do some stuff */
                            }
                        })
                        .create();

        }
        return null;
    }
}// end class
