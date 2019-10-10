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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

public class CheckoutActivity extends AppCompatActivity {
    Handler mHandler = new Handler();
    ArrayList<String> datas = new ArrayList<>();
    TextView tv_book_name;
    TextView tv_book_writer;
    TextView tv_book_company;
    TextView tv_book_content;


    int book_num;
    String book_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_selectone);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        tv_book_name = (TextView) findViewById(R.id.book_name);
        tv_book_writer = (TextView) findViewById(R.id.book_writer);
        tv_book_company = (TextView) findViewById(R.id.book_company);
        tv_book_content = (TextView) findViewById(R.id.book_content);


        // info 가져오기
        Intent intent = getIntent();
        Log.i("testLog", intent.getStringExtra("info"));
        // 자르기
        String[] temp = intent.getStringExtra("info").split(":");

       // datas.add(book_num+":"+book_name+":"+book_writer+":"+book_company+":"+book_checkout);

        book_num = Integer.parseInt(temp[0]);
        Log.i("testLog",""+book_num);
        tv_book_name.setText(temp[1]);
        tv_book_writer.setText(temp[2]);
        tv_book_company.setText(temp[3]);




        new Thread(){
            @Override
            public void run() {
               jsonCheckout();
            }
        }.start();

    }       // onCreate



    public void jsonCheckout(){
        String urlAddress = "http://192.168.0.116:8090/user/book_selectone.do?book_num="+book_num;
        HttpURLConnection conn = null;
        try {


            URL url = new URL(urlAddress);

            conn = (HttpURLConnection) url.openConnection();

            Log.i("Main Log", "conn.getResponseCode():" + conn.getResponseCode());
            if(conn.getResponseCode()== HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer sb = new StringBuffer();
                String line = "";

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                JSONObject jsonObject = new JSONObject(sb.toString());

                Log.i("JSONObject", jsonObject.toString());

                JSONObject jsonObject2 = jsonObject.getJSONObject("result");

                Log.i("JSONObject", jsonObject2.toString());

                book_content = jsonObject2.getString("book_content");


                mHandler.post(new Runnable() {
                    @Override
                    public void run() {


                        tv_book_content.setText(book_content);

                    }
                });


            } } catch (Exception ex) {
            Log.e("Main Log!!", "" + ex);
        } finally {
            conn.disconnect();
        }

        }


   /*private void doProcess() {
//        String num = edit_num.getText().toString();
//        String menu = edit_menu.getText().toString();
//        String price = edit_price.getText().toString();
//        String store = edit_store.getText().toString();
//        String kcal = edit_kcal.getText().toString();

        HttpClient client = new DefaultHttpClient();
        // post방식
        HttpPost post = new HttpPost("http://192.168.0.116:8090/user/book_selectone.do");
        ArrayList<NameValuePair> nameValues =
                new ArrayList<NameValuePair>();
        try {
            nameValues.add(new BasicNameValuePair(
                    "menu", URLEncoder.encode(String.valueOf(book_num), "UTF-8")));


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
                is = new URL("http://192.168.0.116:8090/user/"+sPath).openStream();
            }else{
                is = response.getEntity().getContent();
            }

//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            StringBuffer sb = new StringBuffer();
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                //Log.i("Insert Log", "while>>>>>"+line);
//                sb.append(line);
//            }
//
//            Log.i("Insert Log", sb.toString());
//
//            JSONObject jsonObject = new JSONObject(sb.toString());
//            Log.i("Insert Log", jsonObject.getString("result"));
//
//            insert_result = jsonObject.getString("result");
//
//            if(insert_result.equals("insert successed")){
//                Intent intent = new Intent(
//                        getApplicationContext(),
//                        MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//            }
//
//            mHandler.post(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(
//                            InsertPage.this.getApplicationContext(),
//                            insert_result,
//                            Toast.LENGTH_SHORT).show();
//                }
//            });


        } catch (ClientProtocolException ex) {
            Log.e("Insert Log", ex.toString());
        } catch (IOException ex) {
            Log.e("Insert Log", ex.toString());
//        }catch (JSONException ex) {
//            Log.e("Insert Log", ex.toString());
        }
    }
*/



    // 네비게이션
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_checkout_record:
                    Log.i("testLog", "CheckoutListActivity");
                    Intent checkout_intent = new Intent(getApplicationContext(), CheckoutListActivity.class);
                    checkout_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(checkout_intent);
                    return true;
                case R.id.navigation_list:
                    Log.i("testLog", "BookListActivity");
                    Intent intent = new Intent(getApplicationContext(), BookListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    return true;
                case R.id.navigation_checkout:
                    Intent checkout_QR_intent = new Intent(getApplicationContext(), QRcodeActivity.class);
                    checkout_QR_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(checkout_QR_intent);
                    return true;
            }
            return false;
        }

    };  // navigation

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
            editor.clear();
            editor.commit();

            Intent intent = new Intent(
                    getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

            return true;
        }  else if (id == R.id.ve_account) {
            Log.i("log", "ve_account");
            Intent account_intent = new Intent(getApplicationContext(), UserUpdateActivity.class);
            account_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(account_intent);
        /*else if (id == R.id.navigation_dashboard){
            Log.i("log","navigation_dashboard");
            return true;
        }  else if (id == R.id.navigation_notifications){
            Log.i("log","navigation_notifications");
            return true;
        }*/
        }

        return super.onOptionsItemSelected(item);
    }

}
