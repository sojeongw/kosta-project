package com.test.bookadmin2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
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

public class BookListActivity extends AppCompatActivity {

    // ==========================================
    // ===========  book_selectAll()  ============
    // ==========================================
    private LinearLayout selectLayout;
    private ListView lv_book;

    // ==========================================
    // ======   book_checkOutSelectAll()  =======
    // ==========================================
    private LinearLayout selectcheckoutLayout;
    private ListView lv_checkout_book;
    private Button btn_book_return;

    // ==========================================
    // ===========  book_insertOK()  ============
    // ==========================================
    private LinearLayout insertLayout;
    private EditText et_book_num;
    private EditText et_book_name;
    private EditText et_book_writer;
    private EditText et_book_company;
    private EditText et_book_content;
    private String insert_result;

    // =================================================
    // ===========  book_update_deleteOK()  ============
    // =================================================

    private LinearLayout updateLayout;
    private TextView txt_book_update_num;
    private EditText et_book_update_name;
    private EditText et_book_update_writer;
    private EditText et_book_update_compnay;
    private String delete_result;
    private Handler mHandler = new Handler();


    private static final int DELETE_MESSAGE = 1;

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DELETE_MESSAGE:
                return new AlertDialog.Builder(BookListActivity.this)
                        .setIconAttribute(android.R.attr.alertDialogIcon)
                        .setTitle(R.string.alert_dialog_delete_title)
                        .setMessage(R.string.aler_dialog_delete_really)
                        .setPositiveButton(R.string.alert_dialog_deleteOk, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                new Thread() {
                                    @Override
                                    public void run() {
                                         book_deleteOK(txt_book_update_num.getText().toString());
                                        }
                                    }.start();

                            }
                        })
                        .setNegativeButton(R.string.alert_dialog_delete_cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                        /* User clicked Cancel so do some stuff */
                            }
                        })
                        .create();
        }
        return null;
    }

    // =================================================
    // ===============  NavigationView  ================
    // =================================================

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_book_list:
                    insertLayout.setVisibility(View.GONE);
                    updateLayout.setVisibility(View.GONE);
                    selectcheckoutLayout.setVisibility(View.GONE);
                    selectLayout.setVisibility(View.VISIBLE);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            selectAll();
                        }
                    });
                    return true;
                case R.id.navigation_book_insert:
                    selectLayout.setVisibility(View.GONE);
                    updateLayout.setVisibility(View.GONE);
                    selectcheckoutLayout.setVisibility(View.GONE);
                    insertLayout.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_check:
                    selectLayout.setVisibility(View.GONE);
                    updateLayout.setVisibility(View.GONE);
                    selectcheckoutLayout.setVisibility(View.VISIBLE);
                    insertLayout.setVisibility(View.GONE);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            checkOutSelectAll();
                        }
                    });
                    return true;
            }
            return false;
        }

    };

    // =================================================
    // ==================  onCreate  ===================
    // =================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    // =================================================
    // ==================  onResume  ===================
    // =================================================


    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.list_book);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // ==========================================
        // ===========  book_selectAll()  ============
        // ==========================================
        selectLayout = (LinearLayout)findViewById(R.id.selectLayout);
        selectLayout.setVisibility(View.VISIBLE);
        lv_book = (ListView) findViewById(R.id.lv_book);

        // ==========================================
        // ======   book_checkOutSelectAll()  =======
        // ==========================================
        selectcheckoutLayout = (LinearLayout)findViewById(R.id.selectcheckoutLayout);
        selectcheckoutLayout.setVisibility(View.GONE);
        lv_checkout_book = (ListView)findViewById(R.id.lv_checkout_book);
        btn_book_return = (Button)findViewById(R.id.btn_book_return);
        btn_book_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReturnActivity.class);
                startActivity(intent);
            }
        });

        // ==========================================
        // ===========  book_insertOK()  ============
        // ==========================================
        insertLayout = (LinearLayout)findViewById(R.id.insertLayout);
        insertLayout.setVisibility(View.GONE);

        et_book_num = (EditText) findViewById(R.id.et_book_num);
        et_book_name = (EditText) findViewById(R.id.et_book_name);
        et_book_writer = (EditText) findViewById(R.id.et_book_writer);
        et_book_company = (EditText) findViewById(R.id.et_book_company);
        et_book_content = (EditText) findViewById(R.id.et_book_content);

        Button btn_book_insertOK = (Button)findViewById(R.id.btn_book_insertOK);

        btn_book_insertOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.i("aa","aa");
                new Thread() {
                    @Override
                    public void run() {
                        book_insertOK();
                    }
                }.start();

            }
        });

        // =================================================
        // ===========  book_update_deleteOK()  ============
        // =================================================

        updateLayout = (LinearLayout)findViewById(R.id.updateLayout);
        updateLayout.setVisibility(View.GONE);

        txt_book_update_num = (TextView) findViewById(R.id.txt_book_update_num);
        et_book_update_name = (EditText) findViewById(R.id.et_book_update_name);
        et_book_update_writer = (EditText) findViewById(R.id.et_book_update_writer);
        et_book_update_compnay = (EditText) findViewById(R.id.et_book_update_company);

        Button btn_book_updateOK = (Button)findViewById(R.id.btn_book_updateOK);
        Button btn_book_deleteOK = (Button)findViewById(R.id.btn_book_deleteOK);

        btn_book_deleteOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDialog(DELETE_MESSAGE);
            }
        });

        btn_book_updateOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread() {
                    @Override
                    public void run() {
                        book_updateOK();

                    }
                }.start();
            }
        });

        // ==========================================
        // ===========  book_selectAll()  ===========
        // ==========================================

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                selectAll();
            }
        });

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                checkOutSelectAll();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    // ==========================================
    // ===========  book_insertOK()  ============
    // ==========================================

    public void book_insertOK() {

        String book_num = et_book_num.getText().toString();
        String book_name = et_book_name.getText().toString();
        String book_writer = et_book_writer.getText().toString();
        String book_company = et_book_company.getText().toString();
        String book_content = et_book_content.getText().toString();


        Log.i("Insert Log", book_num);
        Log.i("Insert Log", book_name);
        Log.i("Insert Log", book_writer);
        Log.i("Insert Log", book_company);
        Log.i("Insert Log", book_content);

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://192.168.0.113:8090/admin/insertOK.do");
        ArrayList<NameValuePair> nameValues =
                new ArrayList<NameValuePair>();
        try {

            nameValues.add(new BasicNameValuePair(
                    "book_num", URLEncoder.encode(book_num, "UTF-8")));
            nameValues.add(new BasicNameValuePair("book_name", URLEncoder.encode(book_name, "UTF-8")));
            nameValues.add(new BasicNameValuePair("book_writer", URLEncoder.encode(book_writer, "UTF-8")));
            nameValues.add(new BasicNameValuePair("book_company", URLEncoder.encode(book_company, "UTF-8")));
            nameValues.add(new BasicNameValuePair("book_content", URLEncoder.encode(book_content, "UTF-8")));

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
                is = new URL("http://192.168.0.113:8090/admin/"+sPath).openStream();
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

            if(insert_result.equals("insert successed")){
                Intent intent = new Intent(
                        getApplicationContext(),
                        BookListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(
                            BookListActivity.this.getApplicationContext(),
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


    // ==========================================
    // ===========  book_deleteOK()  ============
    // ==========================================

    public void book_deleteOK(String num) {
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL("http://192.168.0.113:8090/admin/deleteOK.do?book_num="+num);
            Log.i("testLog",num);
            conn = (HttpURLConnection) url.openConnection();
            Log.i("MainActivity", "getContentType>>" + conn.getContentType());
            Log.i("MainActivity", "getResponseMessage>>" + conn.getResponseMessage());
            Log.i("MainActivity", "getResponseCode>>" + conn.getResponseCode());
            Log.i("MainActivity", "getContentLength>>" + conn.getContentLength());

            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = null;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            Log.i("MainActivity", sb.toString());

            final String txtJSON = sb.toString();

            try {
                JSONObject obj = new JSONObject(txtJSON);

                delete_result = obj.getString("result");

                if(delete_result.equals("delete successed")){
                    Intent intent = new Intent(
                            getApplicationContext(),
                            BookListActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(
                                BookListActivity.this.getApplicationContext(),
                                delete_result,
                                Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }

        }
    }

    // ==========================================
    // ===========  book_updateOK()  ============
    // ==========================================

    public void book_updateOK() {
        String book_num = txt_book_update_num.getText().toString();
        String book_name = et_book_update_name.getText().toString();
        String book_writer = et_book_update_writer.getText().toString();
        String book_company = et_book_update_compnay.getText().toString();


        Log.i("Insert Log", book_name);
        Log.i("Insert Log", book_writer);
        Log.i("Insert Log", book_company);

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://192.168.0.113:8090/admin/updateOK.do");
        ArrayList<NameValuePair> nameValues =
                new ArrayList<NameValuePair>();
        try {

            nameValues.add(new BasicNameValuePair(
                    "book_num", URLEncoder.encode(book_num, "UTF-8")));
            nameValues.add(new BasicNameValuePair("book_name", URLEncoder.encode(book_name, "UTF-8")));
            nameValues.add(new BasicNameValuePair("book_writer", URLEncoder.encode(book_writer, "UTF-8")));
            nameValues.add(new BasicNameValuePair("book_company", URLEncoder.encode(book_company, "UTF-8")));

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
                is = new URL("http://192.168.0.113:8090/admin/"+sPath).openStream();
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
                        getApplicationContext(),
                        BookListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(
                            BookListActivity.this.getApplicationContext(),
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

    // ==========================================
    // ======   book_checkOutSelectAll()  =======
    // ==========================================

    public void checkOutSelectAll(){
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL("http://192.168.0.113:8090/admin/checkOutSelectAll.do");
            conn = (HttpURLConnection)url.openConnection();
            Log.i("MainActivity","getContentType>>"+conn.getContentType());
            Log.i("MainActivity","getResponseMessage>>"+conn.getResponseMessage());
            Log.i("MainActivity","getResponseCode>>"+conn.getResponseCode());
            Log.i("MainActivity","getContentLength>>"+conn.getContentLength());

            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = null;
            StringBuilder sb = new StringBuilder();
            while((str=br.readLine())!=null){
                sb.append(str);
            }
            Log.i("MainActivity",sb.toString());

            final String txtJSON = sb.toString();

            final ArrayList<String> datas = new ArrayList<>();
            try {
                JSONArray array = new JSONArray(txtJSON);
                for(int i=0;i<array.length();i++){
                    JSONObject obj = array.getJSONObject(i);
                    String book_name = obj.getString("book_name");
                    String book_writer = obj.getString("book_writer");
                    String book_company = obj.getString("book_company");
                    String user_id = obj.getString("user_id");
                    String user_name = obj.getString("user_name");
                    String user_tel = obj.getString("user_tel");
                    String checkout_start = obj.getString("checkout_start");
                    String checkout_end = obj.getString("checkout_end");

                    Log.i("MainActivity",book_name+":"+book_writer+":"+book_company);
                    datas.add("책 제목 : "+book_name+" 저자 : "+book_writer+" 출판사 : "+book_company+" 사용자ID : "+user_id+" 사용자이름 : "+user_name+" 전화번호 : "+user_tel+" 대출날 : "+checkout_start+" 반납예정일 : "+checkout_end);
                }
                lv_checkout_book.setAdapter(new ArrayAdapter<String>(
                        this,
                        R.layout.list_item,
                        datas));
                lv_checkout_book.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int positon, long id) {
                        Log.i("testLog" ,""+datas.get(positon));
                        final String[] temp = datas.get(positon).split(":");
                        Log.i("testLog" ,""+temp[0]);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
                        Toast.makeText(getApplicationContext(), datas.get(positon), Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }

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

    // ==========================================
    // ===========  book_selectAll()  ===========
    // ==========================================

    public void selectAll(){
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL("http://192.168.0.113:8090/admin/selectAll.do");
            conn = (HttpURLConnection)url.openConnection();
            Log.i("MainActivity","getContentType>>"+conn.getContentType());
            Log.i("MainActivity","getResponseMessage>>"+conn.getResponseMessage());
            Log.i("MainActivity","getResponseCode>>"+conn.getResponseCode());
            Log.i("MainActivity","getContentLength>>"+conn.getContentLength());

            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = null;
            StringBuilder sb = new StringBuilder();
            while((str=br.readLine())!=null){
                sb.append(str);
            }
            Log.i("MainActivity",sb.toString());

            final String txtJSON = sb.toString();

            final ArrayList<String> datas = new ArrayList<>();
            try {
                JSONArray array = new JSONArray(txtJSON);
                for(int i=0;i<array.length();i++){
                    JSONObject obj = array.getJSONObject(i);
                    int book_num = obj.getInt("book_num");
                    String book_name = obj.getString("book_name");
                    String book_writer = obj.getString("book_writer");
                    String book_company = obj.getString("book_company");
                    Boolean book_check = obj.getBoolean("book_checkout");

                    Log.i("MainActivity",book_num+":"+book_name+":"+book_writer+":"+book_company+":"+book_check);
                    datas.add(book_num+":"+book_name+":"+book_writer+":"+book_company+":"+book_check);
                }
                lv_book.setAdapter(new ArrayAdapter<String>(
                        this,
                        R.layout.list_item,
                        datas));
                lv_book.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int positon, long id) {
                        Log.i("testLog" ,""+datas.get(positon));
                        final String[] temp = datas.get(positon).split(":");
                        Log.i("testLog" ,""+temp[0]);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                txt_book_update_num.setText(temp[0]);
                                et_book_update_name.setText(temp[1]);
                                et_book_update_writer.setText(temp[2]);
                                et_book_update_compnay.setText(temp[3]);
                                selectLayout.setVisibility(View.GONE);
                                selectcheckoutLayout.setVisibility(View.GONE);
                                insertLayout.setVisibility(View.GONE);
                                updateLayout.setVisibility(View.VISIBLE);
                            }
                        });
                        Toast.makeText(getApplicationContext(), datas.get(positon), Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }

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

}
