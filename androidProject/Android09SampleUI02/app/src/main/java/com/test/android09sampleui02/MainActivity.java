package com.test.android09sampleui02;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView mImageView;
    private Button mButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    mTextMessage.setVisibility(View.VISIBLE);
                    mImageView.setVisibility(View.INVISIBLE);
                    mButton.setVisibility(View.INVISIBLE);

                    mTextMessage.setText(R.string.title_home);
//                  mTextMessage.setText(99); >> 에러
//                  mTextMessage.setText("99"); >> 가능
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setVisibility(View.INVISIBLE);
                    mImageView.setVisibility(View.VISIBLE);
                    mButton.setVisibility(View.INVISIBLE);

                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setVisibility(View.INVISIBLE);
                    mImageView.setVisibility(View.INVISIBLE);
                    mButton.setVisibility(View.VISIBLE);
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mButton = (Button) findViewById(R.id.button);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // String.xml에 정의했던 값을 string으로 가져오는 법
        String app_name = getResources().getString(R.string.app_name);

        // String.xml의 array를 가져오는 법
        String[] datas = getResources().getStringArray(R.array.datas);



    }   // end of onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.navigation_home) {
            Log.i("log","action_settings");
            return true;
        } else if (id == R.id.navigation_dashboard){
            Log.i("log","navigation_dashboard");
            return true;
        }  else if (id == R.id.navigation_notifications){
            Log.i("log","navigation_notifications");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
