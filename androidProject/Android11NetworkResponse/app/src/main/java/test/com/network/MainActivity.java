package test.com.network;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textView) ;



        new Thread() {
            @Override
            public void run() {
                test();
            }
        }.start();

    }


    public void test() {
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL("http://192.168.0.107:8090/spring02/android_deleteOK.do?num=2");
            conn = (HttpURLConnection) url.openConnection();
            Log.i("MainActivity", "getContentType>>" + conn.getContentType());
            // ResponseMessage와 ResponseCode는 꼭 체크해서 정상적으로 돌고 있는지 체크해야 한다.
            // code가 200인지 확인하고 그럴때만 아래를 실행하게 하거나 등등
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
                final String result = obj.getString("result");

                Log.i("MainActivity", "result:" + result);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        textview.setText(result);
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


}
