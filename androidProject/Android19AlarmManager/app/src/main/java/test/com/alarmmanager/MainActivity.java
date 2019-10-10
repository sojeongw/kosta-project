package test.com.alarmmanager;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    private static final int REQUEST_CODE_CALL_PHONE = 2;
    private AlarmManager manager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 최초 실행시 정말 그 권한을 줄건지 확인하는 창
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CODE_CALL_PHONE);
        }

        manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

//        Intent intent = new Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse("http://yangssem.blog.me"));

//        Intent intent = new Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse("tel:010-0000-0000"));

        Intent intent = new Intent(
                // 누르면 바로 전화를 걸어버림
                Intent.ACTION_CALL,
                Uri.parse("tel:010-3858-9494"));

                // 번호 누르는 화면으로
                // Intent.ACTION_VIEW

        pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                intent,
                PendingIntent.FLAG_ONE_SHOT
        );


        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog","alarm start");

                manager.set(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis()+5000,
                        pendingIntent);

            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("testLog", "onDestroy  manager.cancel...");
//        manager.cancel(pendingIntent);
//        pendingIntent = null;
//        manager = null;
    }
}
