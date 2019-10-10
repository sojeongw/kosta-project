package com.test.bookuser;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
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

public class UserUpdateActivity extends AppCompatActivity {

    private TextView txt_user_id;
    private EditText et_user_pw;
    private EditText et_user_name;
    private EditText et_user_tel;
    private EditText et_user_email;
    private EditText et_user_address;
    private Button btn_user_updateOK;
    private Button btn_user_delete;
    private Button btn_book_list;
    String id;
    String pw;
    String name;
    String tel;
    String email;
    String address;
    SharedPreferences preferences;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_user);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        txt_user_id = (TextView) findViewById(R.id.txt_user_id);
        et_user_pw = (EditText) findViewById(R.id.et_user_pw);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_user_tel = (EditText) findViewById(R.id.et_user_tel);
        et_user_email = (EditText) findViewById(R.id.et_user_email);
        et_user_address = (EditText) findViewById(R.id.et_user_address);
        btn_user_updateOK = (Button) findViewById(R.id.btn_user_updateOK);
        btn_user_delete = (Button)findViewById(R.id.btn_user_delete);

        preferences = getSharedPreferences("test", 0);
        id = preferences.getString("id", null);




        new Thread() {
            @Override
            public void run() {
                setting();
            }
        }.start();


        btn_user_updateOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        doUpdate();
                    }
                }.start();
        }
        });

        btn_user_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showMessage();

//                new Thread() {
//                    @Override
//                    public void run() {
//
//                        doDelete();
//
//                    }
//                }.start();
            }
        });



//        btn_book_list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(
//                        getApplicationContext(), BookListActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//            }
//        });

    }


    private void showMessage(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("정말 삭제하시겠습니까?");


        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }
        );


        builder.setPositiveButton("예", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                                        new Thread() {
                    @Override
                    public void run() {

                        doDelete();

                    }
                }.start();


                    }
                }
        );


        builder.setNeutralButton("취소", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }
        );


        AlertDialog dialog = builder.create();
        dialog.show();


    }


  private void doDelete(){

      HttpClient client = new DefaultHttpClient();
      HttpPost post = new HttpPost("http://192.168.0.116:8090/user/delete.do?id="+id);
      ArrayList<NameValuePair> nameValues =
              new ArrayList<NameValuePair>();

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

          Log.i("Delete Log", response.toString());
          Log.i("Delete Log", "response.getStatusCode:" +response.getStatusLine().getStatusCode());

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
              is = new URL("http://192.168.0.116:8090/user/delete.do/"+sPath).openStream();
          }else{
              is = response.getEntity().getContent();
          }

          BufferedReader br = new BufferedReader(new InputStreamReader(is));
          StringBuffer sb = new StringBuffer();
          String line = "";
          while ((line = br.readLine()) != null) {
              sb.append(line);
          }

          Log.i("Delete Log", sb.toString());

          JSONObject jsonObject = new JSONObject(sb.toString());
          Log.i("Delete Log", jsonObject.getString("result"));

          insert_result = jsonObject.getString("result");

          if(insert_result.equals("delete successed")){
              Intent intent = new Intent(
                      getApplicationContext(), MainActivity.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(intent);
          }

          mHandler.post(new Runnable() {
              @Override
              public void run() {
                  Toast.makeText(
                          UserUpdateActivity.this.getApplicationContext(),
                          insert_result,
                          Toast.LENGTH_SHORT).show();
              }
          });


      } catch (ClientProtocolException ex) {
          Log.e("Delete Log", ex.toString());
      } catch (IOException ex) {
          Log.e("Delete Log", ex.toString());
      }catch (JSONException ex) {
          Log.e("Delete Log", ex.toString());
      }



  }




    ArrayList<String> info;
    private void setting(){
        txt_user_id.setText(id);

        String urlAddress = "http://192.168.0.116:8090/user/selectone.do?user_id="+id;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlAddress);

            conn = (HttpURLConnection) url.openConnection();

            Log.i("Main Log", "conn.getResponseCode():" + conn.getResponseCode());
            if(conn.getResponseCode()== HttpURLConnection.HTTP_OK){
                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer sb = new StringBuffer();
                String line = "";

                while((line = br.readLine()) != null){
                    sb.append(line);
                }

                   JSONObject jsonObject = new JSONObject(sb.toString());

                    Log.i("JSONObject",jsonObject.toString());

                    JSONObject jsonObject2 = jsonObject.getJSONObject("result");

                    Log.i("JSONObject",jsonObject2.toString());
                    Log.i("Main Log", jsonObject2.getString("user_id"));
                    Log.i("Main Log", jsonObject2.getString("user_pw"));
                    Log.i("Main Log", jsonObject2.getString("user_name"));
                    Log.i("Main Log", jsonObject2.getString("user_tel"));

                name = jsonObject2.getString("user_name");
                pw = jsonObject2.getString("user_pw");
                tel = jsonObject2.getString("user_tel");
                email = jsonObject2.getString("user_email");
                address = jsonObject2.getString("user_address");

                Log.i("name",name);
                Log.i("pw",pw);
                Log.i("tel",tel);
                Log.i("email",email);
                Log.i("address",address);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        et_user_tel.setText(tel);
                        et_user_pw.setText(pw);
                        et_user_name.setText(name);
                        et_user_email.setText(email);
                        et_user_address.setText(address);
                    }
                });



                }

        } catch (Exception ex) {
            Log.e("Main Log!!", "" + ex);
        } finally {
            conn.disconnect();
        }

    }


    private Handler mHandler = new Handler();
    private String insert_result;

    private void doUpdate() {

        String id = txt_user_id.getText().toString();
        String pw = et_user_pw.getText().toString();
        String name = et_user_name.getText().toString();
        String tel = et_user_tel.getText().toString();
        String email = et_user_email.getText().toString();
        String address = et_user_address.getText().toString();


        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://192.168.0.116:8090/user/updateOK.do");
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
                is = new URL("http://192.168.0.116:8090/user/updateOK.do/"+sPath).openStream();
            }else{
                is = response.getEntity().getContent();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            Log.i("Insert Log", sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            Log.i("Insert Log", jsonObject.getString("result"));

            insert_result = jsonObject.getString("result");

            if(insert_result.equals("update successed")){
                Intent intent = new Intent(
                        getApplicationContext(), BookListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(
                            UserUpdateActivity.this.getApplicationContext(),
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

