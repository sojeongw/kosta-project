package test.com.sensor2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView textView_x;
    private TextView textView_y;
    private TextView textView_z;

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

                if(event.values[0] > 19 || event.values[0] < -19){
                    soundPool.play(soundID,1,1,0,0,1);
                }

                break;
            default:
                break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
