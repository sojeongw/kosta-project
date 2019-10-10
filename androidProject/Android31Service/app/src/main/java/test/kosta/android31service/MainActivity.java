package test.kosta.android31service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btn_startService;
    private Button btn_stopService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* 이렇게 위로 올리고 있던 곳을 주석처리하면 화면이 뜨지 않아도 인식한다.
        startService(new Intent(getApplicationContext(),TestService.class));
        finish();*/

       // 서비스란 백그라운드 단에서 돌아가는 프로그램을 얘기한다.

        btn_startService = (Button)findViewById(R.id.startService);
        btn_stopService = (Button)findViewById(R.id.stopService);


        btn_startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(),TestService.class));
                finish();
            }
        });
        btn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(),TestService.class));
            }
        });

    }
}
