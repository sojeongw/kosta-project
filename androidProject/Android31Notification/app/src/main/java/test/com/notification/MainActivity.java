package test.com.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testClick(View v){
        Log.i("testLog", "testClick().....");
        NotificationManager manager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        if(v.getId()==R.id.button){
            String title = "제목";
            String cotent = "내용입니다.";
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(getApplicationContext());

            // resource나 drawable에 있는 이미지를 비트맵 byte배열로 decode
            // Bitmap bitmap = BitmapFactory.decode 여기까지는 세트고 그 뒤에는 뭐가 올거냐에 따라 달라진다.
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

            builder.setLargeIcon(bitmap);
            builder.setSmallIcon(android.R.drawable.ic_input_delete);
            builder.setContentTitle(title);
            builder.setContentText(cotent);

            Uri sound = RingtoneManager.getActualDefaultRingtoneUri(
                    getApplicationContext(),
                    RingtoneManager.TYPE_NOTIFICATION);
            builder.setSound(sound);

            // 0초 멈춤 / 3초 진동 / 0.1초 멈춤 / 0.1초 진동 / 0.2초 멈춤 / 0.2초 진동
            long[] vibrates = new long[]{0,3000,100,100,200,200};
            builder.setVibrate(vibrates);

            // 이벤트가 발생하는 즉히 하면 startActivity
            // 잠시 대기하고 있다가 이벤트가 정확히 발생할때 딱 나오는거면 pendingIntent

            // dialog 창을 띄워야 하는데 클릭 하면 띄워야 하므로 잠들어 있어야 함
            Intent intent = new Intent(getApplicationContext(),DialogViewPage.class);
            intent.putExtra("title",title);
            intent.putExtra("content",cotent);

            TaskStackBuilder tsBuilder = TaskStackBuilder.create(this);
            tsBuilder.addParentStack(getClass());
            tsBuilder.addNextIntent(intent);

            PendingIntent pIntent = tsBuilder.getPendingIntent(
                    0,PendingIntent.FLAG_UPDATE_CURRENT
            );

            builder.setContentIntent(pIntent);
            builder.setAutoCancel(true);


            manager.notify(1, builder.build());
        }else if(v.getId()==R.id.button2){

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(getApplicationContext());

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.sample_0);

            builder.setLargeIcon(bitmap);
            builder.setSmallIcon(android.R.drawable.ic_btn_speak_now);
            builder.setContentTitle("제목2");
            builder.setContentText("내용입니다2.");


            // 자기 자신의 클래스를 구현해라
            Intent intent = new Intent(getApplicationContext(),getClass());
            TaskStackBuilder tsBuilder = TaskStackBuilder.create(this);
            tsBuilder.addParentStack(getClass());
            tsBuilder.addNextIntent(intent);

            PendingIntent pIntent = tsBuilder.getPendingIntent(
                    0,PendingIntent.FLAG_UPDATE_CURRENT
            );

            builder.setContentIntent(pIntent);
            // 내렸을 때 clear all이나 클릭하면 지워지는 기능
            builder.setAutoCancel(true);


            manager.notify(2,builder.build());
        }
    }



}
