package com.test.android36http;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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


public class InsertPage extends Activity {

    private EditText edit_num;
    private EditText edit_menu;
    private EditText edit_price;
    private EditText edit_store;
    private EditText edit_kcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        edit_num = (EditText) findViewById(R.id.edit_num);
        edit_menu = (EditText) findViewById(R.id.edit_menu);
        edit_price = (EditText) findViewById(R.id.edit_price);
        edit_store = (EditText) findViewById(R.id.edit_store);
        edit_kcal = (EditText) findViewById(R.id.edit_kcal);

        Button insertOKBtn = (Button) findViewById(R.id.insertOKBtn);
        insertOKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Insert Log", edit_num.getText().toString());
                Log.i("Insert Log", edit_menu.getText().toString());
                Log.i("Insert Log", edit_price.getText().toString());
                Log.i("Insert Log", edit_store.getText().toString());
                Log.i("Insert Log", edit_kcal.getText().toString());

                new Thread() {
                    @Override
                    public void run() {
                        doProcess();
                    }
                }.start();



            }
        });

    }

    private Handler mHandler = new Handler();
    private String insert_result;

    private void doProcess() {
        String num = edit_num.getText().toString();
        String menu = edit_menu.getText().toString();
        String price = edit_price.getText().toString();
        String store = edit_store.getText().toString();
        String kcal = edit_kcal.getText().toString();

        HttpClient client = new DefaultHttpClient();
        // post방식
        HttpPost post = new HttpPost("http://192.168.0.126:8090/spring01menu/insert.do");
        ArrayList<NameValuePair> nameValues =
                new ArrayList<NameValuePair>();
        try {
            nameValues.add(new BasicNameValuePair(
                    "menu", URLEncoder.encode(menu, "UTF-8")));
            nameValues.add(new BasicNameValuePair("price", URLEncoder.encode(price, "UTF-8")));
            nameValues.add(new BasicNameValuePair("store", URLEncoder.encode(store, "UTF-8")));
            nameValues.add(new BasicNameValuePair("kcal", URLEncoder.encode(kcal, "UTF-8")));
            nameValues.add(new BasicNameValuePair("num", URLEncoder.encode(num, "UTF-8")));

            post.setEntity(
                    new UrlEncodedFormEntity(
                            nameValues, "UTF-8"));

        } catch (UnsupportedEncodingException ex) {
            Log.e("Insert Log", ex.toString());
        }
        // 여기까진 전송세팅


        try {
            // 이제 실행해
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
                is = new URL("http://192.168.0.126:8090/spring01menu/"+sPath).openStream();
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

            if(insert_result.equals("insert successed")){
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(
                            InsertPage.this.getApplicationContext(),
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
