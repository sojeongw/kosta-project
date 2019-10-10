package com.test.android36http;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        new Thread() {
            @Override
            public void run() {
                doProcess();
            }
        }.start();

        Button gotoInsertBtn = (Button)findViewById(R.id.gotoInsertBtn);
        gotoInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        InsertPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }



    ArrayList<String> members;
    private void doProcess() {
        members = new ArrayList<>();
        String urlAddress = "http://192.168.0.126:8090/spring01menu/jselectAll.do";
        HttpURLConnection conn = null;

        try {
            URL url = new URL(urlAddress);

            conn = (HttpURLConnection) url.openConnection();

            Log.i("Main Log", "conn.getResponseCode():" + conn.getResponseCode());
            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer sb = new StringBuffer();
                String line = "";
                while((line = br.readLine()) != null){
                    sb.append(line);
                }

                Log.i("Main Log", sb.toString());

                JSONObject jsonObject = new JSONObject(sb.toString());

                JSONArray jsonArray = new JSONArray(
                        jsonObject.getString("list"));

                for (int i=0;i<jsonArray.length();i++){
                    Log.i("Main Log", jsonArray.getJSONObject(i).getInt("num")+"");
                    Log.i("Main Log", jsonArray.getJSONObject(i).getString("menu"));
                    Log.i("Main Log", jsonArray.getJSONObject(i).getString("store"));
                    Log.i("Main Log", jsonArray.getJSONObject(i).getInt("price")+"");
                    Log.i("Main Log", jsonArray.getJSONObject(i).getInt("kcal")+"");
                    int num = jsonArray.getJSONObject(i).getInt("num");
                    String menu = jsonArray.getJSONObject(i).getString("menu");
                    String store = jsonArray.getJSONObject(i).getString("store");
                    int price = jsonArray.getJSONObject(i).getInt("price");
                    int kcal = jsonArray.getJSONObject(i).getInt("kcal");

                    members.add(num+":"+menu+":"+store+":"+price+kcal);
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        ListView lv = (ListView)findViewById(R.id.listView);
                        lv.setAdapter(new ArrayAdapter<String>(
                                MainActivity.this.getApplicationContext(),
                                R.layout.row,
                                members));
                    }
                });
            }//end if
        } catch (Exception ex) {
            Log.e("Main Log", "" + ex);
        } finally {
            conn.disconnect();
        }

    }

    private Handler mHandler = new Handler();


}
