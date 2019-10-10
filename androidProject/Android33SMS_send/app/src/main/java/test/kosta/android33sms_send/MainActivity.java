package test.kosta.android33sms_send;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String PhoneNum;
    private static final int REQUEST_CODE_LOCATION = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            // Request missing SEND_SMS permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    REQUEST_CODE_LOCATION);
        }


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneNum = "01046557478";
                SmsManager mSmsManager = SmsManager.getDefault();
                mSmsManager.sendTextMessage(
                        PhoneNum, null,
                        "누나 그 선배한테 가지 마요...내가 더 잘해요...-강준",
                        null, null);
            }
        });




    }

//
//    public void testClick(View v){
//        PhoneNum = "01038589494";
//        SmsManager mSmsManager = SmsManager.getDefault();
//        mSmsManager.sendTextMessage(
//                PhoneNum, null,
//                "전화해~~~~^^",
//                null, null);
//    }

}
