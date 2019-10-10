package com.test.bookuser;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckoutListActivity extends AppCompatActivity {
    Handler mHandler = new Handler();
    ArrayList<String> datas = new ArrayList<>();
    // 리스트
    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_checkout);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

       /* // 리스트 클릭
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("testLog","lv");
                Log.i("testLog",datas.get(position));

                // 메시지 출력
                Toast.makeText(getApplicationContext(), datas.get(position),
                        Toast.LENGTH_SHORT).show();
               *//* // 보내기
                Intent intent = new Intent(getApplicationContext(), CheckoutListActivity.class);
                // 창 순서
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // 데이터 전송
                intent.putExtra("info", datas.get(position));
                // 실행
                startActivity(intent) ;*//*
            }
        });*/

        new Thread(){
            @Override
            public void run() {
                jsonCheckoutList();
            }
        }.start();


    }       // onCreate

    public void jsonCheckoutList(){
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {

            URL url = new URL("http://192.168.0.116:8090/user/checkoutList.do");
            conn = (HttpURLConnection)url.openConnection();
            Log.i("BookListActivity","getContentType>>"+conn.getContentType());
            Log.i("BookListActivity","getResponseMessage>>"+conn.getResponseMessage());
            Log.i("BookListActivity","getResponseCode>>"+conn.getResponseCode());
            Log.i("BookListActivity","getContentLength>>"+conn.getContentLength());

            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = null;
            StringBuilder sb = new StringBuilder();
            while((str=br.readLine())!=null){
                sb.append(str);
            }
            Log.i("checkoutList",sb.toString());

            final String txtJSON = sb.toString();


            /*select u.USER_ID, b.book_name, b.book_writer, c.checkout_start, c.CHECKOUT_END
from book_info b, user_info u, checkout c
where u.user_id = c.user_id and b.book_num=c.book_num;*/

            try {
                JSONArray array = new JSONArray(txtJSON);
                for(int i=0;i<array.length();i++){
                    JSONObject obj = array.getJSONObject(i);
                    String book_name = obj.getString("book_name");
                    String book_writer = obj.getString("book_writer");
                    String checkout_start = obj.getString("checkout_start");
                    String checkout_end = obj.getString("checkout_end");

                    Log.i("checkoutList",book_name+":"+book_writer+":"+checkout_start+
                            ":"+checkout_end);

                    datas.add(book_name+":"+book_writer+":"+checkout_start+":"+checkout_end);
                    Log.i("datas", datas.get(i).toString());

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    ListView lv = (ListView) findViewById(R.id.lv);
                    // 레이아웃 적용
                    lv.setAdapter(new ArrayAdapter<String>(CheckoutListActivity.this, R.layout.list_item2, datas));
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
            if(conn!=null){conn.disconnect();}

        }
    }



    // 네비게이션 메뉴
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_checkout_record:

                    Intent checkout_intent = new Intent(getApplicationContext(), CheckoutListActivity.class);
                    checkout_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(checkout_intent);

                    return true;
                case R.id.navigation_list:
                    Intent list_intent = new Intent(getApplicationContext(), BookListActivity.class);
                    list_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(list_intent);
                    return true;
                case R.id.navigation_checkout:
                    Intent checkout_QR_intent = new Intent(getApplicationContext(), QRcodeActivity.class);
                    checkout_QR_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(checkout_QR_intent);
                    return true;
            }
            return false;
        }

    };


    // logout 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vertical_ellipsis, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ve_logout) {
            Log.i("log","logout");
            SharedPreferences preferences = getSharedPreferences("test",0);
            SharedPreferences.Editor editor = preferences.edit();

            preferences = getSharedPreferences("test", 0);
            editor.clear();
            editor.commit();
            Intent intent = new Intent(
                    getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        } else if (id == R.id.ve_account){
            Log.i("log","ve_account");
            Intent account_intent = new Intent(getApplicationContext(), UserUpdateActivity.class);
            account_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(account_intent);



            return true;
        }  /*else if (id == R.id.navigation_notifications){
            Log.i("log","navigation_notifications");
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }




}
