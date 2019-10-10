package com.test.bookuser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;


public class UserInsertActivity extends AppCompatActivity {

    private EditText et_user_id;
    private EditText et_user_pw;
    private EditText et_user_name;
    private EditText et_user_tel;
    private EditText et_user_address;
    private EditText et_user_email;
    private Button btn_user_insertOK;
    private Button btn_duplication;
    private int dup_check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_user);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        btn_user_insertOK = (Button) findViewById(R.id.btn_user_insertOK);
        btn_duplication = (Button)findViewById(R.id.btn_duplication);


        et_user_id = (EditText) findViewById(R.id.et_user_id);
        et_user_pw = (EditText) findViewById(R.id.et_user_pw);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_user_tel = (EditText) findViewById(R.id.et_user_tel);
        et_user_email = (EditText)findViewById(R.id.et_user_email);
        et_user_address = (EditText) findViewById(R.id.et_user_address);


        btn_user_insertOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Insert Log", et_user_id.getText().toString());
                Log.i("Insert Log", et_user_pw.getText().toString());
                Log.i("Insert Log", et_user_name.getText().toString());
                Log.i("Insert Log", et_user_tel.getText().toString());
                Log.i("Insert Log", et_user_email.getText().toString());
                Log.i("Insert Log", et_user_address.getText().toString());


                new Thread() {
                    @Override
                    public void run() {
                        doProcess();
                    }
                }.start();

            }
        });


        btn_duplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Thread() {
                    @Override
                    public void run() {
                        duplication_check();
                    }
                }.start();



            }
        });


    }


    private void duplication_check(){

            String id = et_user_id.getText().toString();

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://192.168.0.116:8090/user/duplication_check.do?id="+id);
            ArrayList<NameValuePair> nameValues =
                    new ArrayList<NameValuePair>();

        Log.i("id",id);
            try {
                nameValues.add(new BasicNameValuePair("user_id", URLEncoder.encode(id, "UTF-8")));

                post.setEntity(
                        new UrlEncodedFormEntity(
                                nameValues, "UTF-8"));

            } catch (UnsupportedEncodingException ex) {
                Log.e("Insert Log", ex.toString());
            }

            try {
                HttpResponse response = client.execute(post);

                Log.i("duplicateCheck Log", response.toString());
                Log.i("duplicateCheck Log", "response.getStatusCode:" +response.getStatusLine().getStatusCode());

                for(Header x:response.getAllHeaders()){
                    Log.i("Delete Log", x.toString());
                }
                InputStream is = null;
                if(response.getStatusLine().getStatusCode()>=300 &&
                        response.getStatusLine().getStatusCode()<400){
                    Log.i("Delete Log", "response.getFirstHeader(\"Location\"):" +response.getFirstHeader("Location").toString());
                    String location = response.getFirstHeader("Location").toString();
                    String sPath = location.substring("Location: ".length());
                    Log.i("Delete Log", "sPath:"+sPath);
                    is = new URL("http://192.168.0.116:8090/user/duplication_check.do/"+sPath).openStream();
                }else{
                    is = response.getEntity().getContent();
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer sb = new StringBuffer();
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                Log.i("duplicateCheck Log", sb.toString());

                JSONObject jsonObject = new JSONObject(sb.toString());
                Log.i("duplicateCheck Log", jsonObject.getString("result"));

                insert_result = jsonObject.getString("result");

                if(insert_result.equals("You can use this ID")){

                    dup_check = 1;

                }

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(
                                UserInsertActivity.this.getApplicationContext(),
                                insert_result,
                                Toast.LENGTH_SHORT).show();
                    }
                });


            } catch (ClientProtocolException ex) {
                Log.e("duplicateCheck Log", ex.toString());
            } catch (IOException ex) {
                Log.e("duplicateCheck Log", ex.toString());
            }catch (JSONException ex) {
                Log.e("duplicateCheck Log", ex.toString());
            }

        }







    private Handler mHandler = new Handler();
    private String insert_result;
    private void doProcess() {
        String id = et_user_id.getText().toString();
        String pw = et_user_pw.getText().toString();
        String name = et_user_name.getText().toString();
        String tel = et_user_tel.getText().toString();
        String email = et_user_email.getText().toString();
        String address = et_user_address.getText().toString();


        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://192.168.0.116:8090/user/insertOK.do");
        ArrayList<NameValuePair> nameValues =
                new ArrayList<NameValuePair>();

        Log.i("id", id);
        Log.i("pw", pw);
        Log.i("name", name);
        Log.i("tel", tel);
        Log.i("email", email);
        Log.i("address", address);

        try {
            nameValues.add(new BasicNameValuePair("user_id", URLEncoder.encode(id, "UTF-8")));
            nameValues.add(new BasicNameValuePair("user_pw", URLEncoder.encode(pw, "UTF-8")));
            nameValues.add(new BasicNameValuePair("user_name", URLEncoder.encode(name, "UTF-8")));
            nameValues.add(new BasicNameValuePair("user_tel", URLEncoder.encode(tel, "UTF-8")));
            nameValues.add(new BasicNameValuePair("user_email", URLDecoder.decode(email, "UTF-8")));
            nameValues.add(new BasicNameValuePair("user_address", URLEncoder.encode(address, "UTF-8")));

            post.setEntity(
                    new UrlEncodedFormEntity(
                            nameValues, "UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            Log.e("Insert Log", ex.toString());
        }



        try {
            HttpResponse response = client.execute(post);

            Log.i("Insert Log", response.toString());
            Log.i("Insert Log", "response.getStatusCode:" +response.getStatusLine().getStatusCode());

            for(Header x:response.getAllHeaders()){
                Log.i("Insert Log", x.toString());
            }
            InputStream is = null;
            if(response.getStatusLine().getStatusCode()>=300 &&
                    response.getStatusLine().getStatusCode()<400){
                Log.i("Insert Log", "response.getFirstHeader(\"Location\"):" +response.getFirstHeader("Location").toString());
                String location = response.getFirstHeader("Location").toString();
                String sPath = location.substring("Location: ".length());
                Log.i("Insert Log", "sPath:"+sPath);
                is = new URL("http://192.168.0.116:8090/user/insertOK.do/"+sPath).openStream();
            }else{
                is = response.getEntity().getContent();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                //Log.i("Insert Log", "while>>>>>"+line);
                sb.append(line);
            }

            Log.i("Insert Log", sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            Log.i("Insert Log", jsonObject.getString("result"));

            insert_result = jsonObject.getString("result");

        if(dup_check == 1) {
            if (insert_result.equals("insert successed")) {
                Intent intent = new Intent(
                        getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(
                            UserInsertActivity.this.getApplicationContext(),
                            insert_result,
                            Toast.LENGTH_SHORT).show();
                }
            });


        } catch (ClientProtocolException ex) {
            Log.e("Insert Log", ex.toString());
        } catch (IOException ex) {
            Log.e("Insert Log", ex.toString());
        }catch (JSONException ex) {
            Log.e("Insert Log", ex.toString());
        }

    }


}