package test.kosta.android32receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by qkboo on 2016-06-10.
 */
public class TestSMS_Receiver extends BroadcastReceiver {

    static String msg = "test";

    @Override
    public void onReceive(Context context, Intent intent) {
        // 요청이 오면 동작하는 메소드

        Bundle bundle = intent.getExtras();     // getExtras 하면 얘한테 오는 정보를 다 받을 수 있음
        SmsMessage[] msgs = null;
        String str = "";

        if (bundle != null) {
            // 오브젝트 배열에 들어가있는 렝스만큼 메시지를 넣고 그 정보를 msgs배열에 넣는다.
            // 오리지날 어드레스 메소드를 부르면 보낸 사람의 번호가 나오고
            // getMessageBody하면 그 문자를 볼 수 있다.
            Object[] pdus =
                    (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];

            for (int i = 0; i < msgs.length; i++) {
                msgs[i] = SmsMessage.createFromPdu(
                        (byte[]) pdus[i]);
                str += "senderNO:"
                        + msgs[i].getOriginatingAddress();
                str += "\n";
                str += msgs[i].getMessageBody().toString();
            }// end for

            // 그런 다음 토스트에 띄운다
            Toast t = new Toast(context);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.setDuration(Toast.LENGTH_LONG);
            TextView tv = new TextView(context);
            tv.setTextSize(20.0f);
            tv.setText(str);
            tv.setBackgroundResource(
                    android.R.drawable.toast_frame);
            t.setView(tv);
            t.show();

            msg = str;
            // 서비스가 돌고 있다면 일단 정지를 시키고
            context.stopService(new Intent(context, AlwaysOnTopService.class));
            // 해당 서비스를 돌려라
            context.startService(new Intent(context, AlwaysOnTopService.class));

        }
    }
}
