package test.com.network;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class SelectActivity extends AppCompatActivity {
    Handler mHandler = new Handler();
    ListView listview;
    Button btn_delete;
    ArrayList<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        textview = (TextView)findViewById(R.id.textView);
        //btn_delete = (Button) findViewById(R.id.btn_delete);
        listview = (ListView) findViewById(R.id.listview);

        listview.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, datas));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("testLog",datas.get(position));
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog", "btn_delete");
                try {
                    URL url = new URL("http://192.168.0.107:8090/spring02/deleteOK.do?num=1");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        new Thread(){
            @Override
            public void run() {
                test();
            }
        }.start();



    }   // end of onCreate

    public void test(){
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
//            URL url = new URL("http://yangssem.blog.me");
//            URL url = new URL("https://developer.android.com/images/develop/hero_image_studio5.png");
//            URL url = new URL("http://192.168.0.129:8090/web13ServletJSON/json_select2.do");
            URL url = new URL("http://192.168.0.107:8090/spring02/jselectAll2.do");
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


            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    //textview.setText(txtJSON);
                }
            });

            try {
                JSONArray array = new JSONArray(txtJSON);
                for(int i=0;i<array.length();i++){
                    JSONObject obj = array.getJSONObject(i);
                    int num = obj.getInt("num");
                    String menu = obj.getString("menu");
                    int price = obj.getInt("price");
                    String store = obj.getString("store");
                    int kcal = obj.getInt("kcal");
                    Log.i("MainActivity",num+":"+menu+":"+price+":"+store+":"+kcal);

                    datas.add(num+":"+menu+":"+price+":"+store+":"+kcal);
                    Log.i("datas", datas.get(i).toString());

                }
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


}   // end of class


//  listview.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, datas));
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//@Override
//public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Log.i("testLog",datas.get(position));
//        }
//        });