package com.test.bookadmin2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;
import java.io.InputStream;
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

/**
 * Created by jeongho on 2017-09-26.
 */

public class ReturnActivity extends AppCompatActivity {
    // =================================================
    // ===========  book_return()  ============
    // =================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_book);
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureActivityAnyOrientation.class);
        integrator.setOrientationLocked(false);
        integrator.initiateScan();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            Log.i("testLog", requestCode + "");
            Log.i("testLog", resultCode + "");
            Log.i("testLog", data + "");
            if (data == null) {
                // 취소됨
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                onStop();
            } else {
                // 스캔된 QRCode --> result.getContents()
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                book_updateOK(result.getContents());

                Intent intent = new Intent(getApplicationContext(), BookListActivity.class);
                startActivity(intent);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }



public void book_updateOK(String book_num) {

    String book_checkout = "true";


    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost("http://192.168.0.113:8090/admin/returnOK.do");
    ArrayList<NameValuePair> nameValues =
            new ArrayList<NameValuePair>();
    try {
        nameValues.add(new BasicNameValuePair(
                "book_num", URLEncoder.encode(book_num, "UTF-8")));
        nameValues.add(new BasicNameValuePair(
                "book_checkout", URLEncoder.encode(book_checkout, "UTF-8")));

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

//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        StringBuffer sb = new StringBuffer();
//        String line = "";
//        while ((line = br.readLine()) != null) {
//            //Log.i("Insert Log", "while>>>>>"+line);
//            sb.append(line);
//        }

//        Log.i("Insert Log", sb.toString());
//
//        JSONObject jsonObject = new JSONObject(sb.toString());
//        Log.i("Insert Log", jsonObject.getString("result"));
//
//        insert_result = jsonObject.getString("result");
//
//        if(insert_result.equals("update successed")){
//            Intent intent = new Intent(
//                    getApplicationContext(),
//                    BookListActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//        }

//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(
//                        BookListActivity.this.getApplicationContext(),
//                        insert_result,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });


    } catch (ClientProtocolException ex) {
        Log.e("Insert Log", ex.toString());
    } catch (IOException ex) {
        Log.e("Insert Log", ex.toString());
    }
//    }catch (JSONException ex) {
//        Log.e("Insert Log", ex.toString());
//    }
}

}


