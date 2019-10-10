package com.test.android37rockscissorspaper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView textView_x;
    private TextView textView_y;
    private TextView textView_z;
    TextView textView2;

    private SoundPool soundPool;
    int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager =
                (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors =
                sensorManager.getSensorList(
                        Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) {
            sensorManager.registerListener(
                    this,
                    sensors.get(0),
                    SensorManager.SENSOR_DELAY_FASTEST);
        }


        textView_x = (TextView)findViewById(R.id.textView_x);
        textView_y = (TextView)findViewById(R.id.textView_y);
        textView_z = (TextView)findViewById(R.id.textView_z);
        textView2 = (TextView)findViewById(R.id.textView2);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundID = soundPool.load(this,
                R.raw.ding,
                1);//재생우선순위 0,1






    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        switch (sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                Log.i("testLog","x:"+event.values[0]);
                Log.i("testLog","y:"+event.values[1]);
                Log.i("testLog","z:"+event.values[2]);

                textView_x.setText("x:"+event.values[0]);
                textView_y.setText("y:"+event.values[1]);
                textView_z.setText("z:"+event.values[2]);

                //        long endTime = System.currentTimeMillis();
//        final long startTime = System.currentTimeMillis();



                if(event.values[0] > 15 || event.values[0] < -15){
                Random random = new Random();
                int a = random.nextInt(3);
                if(a==0){
                    textView2.setText("가위");
                } else if(a==1){
                    textView2.setText("바위");
                } else  textView2.setText("보");

                Log.i("log", "random"+a);
                }

//                break;
//            default:
//                break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
