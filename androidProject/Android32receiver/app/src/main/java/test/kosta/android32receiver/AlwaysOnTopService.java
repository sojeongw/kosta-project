package test.kosta.android32receiver;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.TextView;

public class AlwaysOnTopService extends Service {
    private TextView tv;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("testLog","service ... onCreate()");

        tv = new TextView(this);
        tv.setText(TestSMS_Receiver.msg);
//        tv.setText("TestSMS_Receiver");
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        tv.setTextColor(Color.BLUE);
        Log.i("testLog",TestSMS_Receiver.msg);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                // 오버레이 옵션이 없으면 홈 화면 위에 뜨질 않는다.
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);

        // 옵션과 텍스트뷰를 보내면 홈화면에 뜨게 된다.
        wm.addView(tv, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (tv != null) {
            ((WindowManager) getSystemService(WINDOW_SERVICE)).removeView(tv);
            tv = null;
        }
    }
}