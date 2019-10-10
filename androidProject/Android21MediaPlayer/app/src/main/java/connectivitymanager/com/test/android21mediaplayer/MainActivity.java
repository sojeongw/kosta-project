package connectivitymanager.com.test.android21mediaplayer;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mp;

    private ImageButton btn_start;
    private Button btn_pause;
    private Button btn_restart;
    private Button btn_stop;

    private int pausePostion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (ImageButton)findViewById(R.id.btn_start);
        btn_pause = (Button)findViewById(R.id.btn_pause);
        btn_restart = (Button)findViewById(R.id.btn_restart);
        btn_stop = (Button)findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
        btn_restart.setOnClickListener(this);
        btn_stop.setOnClickListener(this);



    }

    @Override
    protected void onStop() {
        super.onStop();

        if(mp!=null){
            mp.stop();
            mp.release();
            mp = null;
        }


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_start:
                mp = MediaPlayer.create(getApplicationContext(),
                        R.raw.test_cbr);
                mp.seekTo(7000);
                mp.start();
                break;
            case R.id.btn_pause:
                pausePostion = mp.getCurrentPosition();
                mp.pause();
                break;
            case R.id.btn_restart:
                mp.seekTo(pausePostion);
                mp.start();
                break;
            case R.id.btn_stop:
                mp.stop();
                break;
            default:break;
        }

    }
}
