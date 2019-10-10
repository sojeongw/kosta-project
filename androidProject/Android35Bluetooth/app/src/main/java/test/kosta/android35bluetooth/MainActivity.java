package test.kosta.android35bluetooth;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.util.EncodingUtils;

import java.io.UnsupportedEncodingException;


public class MainActivity extends Activity implements OnClickListener {
    private static final String TAG = "Main";
    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;
    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter = null;
    private BluetoothAppService mAppService = null;
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    EditText mEditText;
    TextView mTextView;
    Button mSendButton;
    Button mScanButton;
    Button mDisconnectButton;
    private Toast toast;
    private static final int REQUEST_CODE_LOCATION = 2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH)
                != PackageManager.PERMISSION_GRANTED) {
            // Request missing BLUETOOTH permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.BLUETOOTH,Manifest.permission.BLUETOOTH_ADMIN},
                    REQUEST_CODE_LOCATION);
        }



        toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);

        TextView tv = new TextView(this);
        tv.setText("");
        toast.setView(tv);

        mEditText = (EditText) findViewById(R.id.editText);
        mTextView = (TextView) findViewById(R.id.textView);
        mSendButton = (Button) findViewById(R.id.send_btn);
        mSendButton.setOnClickListener(this);
        mScanButton = (Button) findViewById(R.id.scan_btn);
        mScanButton.setOnClickListener(this);
    }

    // ==================== remote data call ==========================
    Handler mHandler = new Handler() {
        private SoundPool soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        private int soundID;

        @Override
        public void handleMessage(android.os.Message msg) {


            switch (msg.what) {
                case MESSAGE_STATE_CHANGE:

                    switch (msg.arg1) {
                        case BluetoothAppService.STATE_CONNECTED:

                            Toast.makeText(getApplicationContext(),
                                    "STATE_CONNECTED", Toast.LENGTH_LONG).show();
                            break;

                        case BluetoothAppService.STATE_CONNECTING:
                            Toast.makeText(getApplicationContext(), "STATE_CONNECTING",
                                    Toast.LENGTH_LONG).show();
                            break;

                        case BluetoothAppService.STATE_LISTEN:
                        case BluetoothAppService.STATE_NONE:
                            break;

                    }
                    break;

                case MESSAGE_WRITE:
                    byte[] writeBuf = (byte[]) msg.obj;

                    break;

                case MESSAGE_READ:
                    byte[] readBuf = (byte[]) msg.obj;
                    String str = new String(readBuf);
                    mTextView.setText(str);
                    TextView tv = new TextView(getApplicationContext());
                    tv.setText("MESSAGE_READ");
                    tv.setBackgroundResource(android.R.drawable.toast_frame);
                    toast.setView(tv);
                    toast.show();
                    Log.i("testLog", "new String(readBuf).equals(\"0\")>>>" + str.substring(0,1));
                    if (str.substring(0,1).equals("0")) {

                        final int soundID = soundPool.load(getApplicationContext(),
                                R.raw.camera_click,
                                1);//재생우선순위 0,1
                        soundPool.play(soundID, 1, 1, 0, 0, 1);
//                        soundPool.release();
//                        soundPool = null;
                    }
//                    else{
//                        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
//                        final int soundID = soundPool.load(getApplicationContext(),
//                                R.raw.camera_click,
//                                1);//재생우선순위 0,1
//                        soundPool.play(soundID, 1, 1, 0, 0, 1);
////                        soundPool.release();
////                        soundPool = null;
//                    }
                    break;
            }

        }
    };

    public String byteToString(byte[] $byte) {

        return EncodingUtils.getString($byte, 0, $byte.length, "Latin-1");

    }

    @Override
    protected void onStop() {
        super.onStop();
//        soundPool.release();
//        soundPool = null;
    }

    protected void Send(String text) {
        sendMessage(text);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop the Bluetooth chat services
        if (mAppService != null)
            mAppService.stop();
    }

    private void bluetoothOn() {
        if (!isAvailableBluetooth()) {
            Toast.makeText(this, "bluetoothOn", Toast.LENGTH_LONG)
                    .show();
        }

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(
                    // 블루투스 가능한 목록을 읽어서
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            // 정보들을 받아서 뒤에서 list로 보냄
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
            // Otherwise, setup the chat session
        } else {
            if (mAppService == null)
                setupChat();
        }
    }

    private boolean isAvailableBluetooth() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter == null) {
            return false;
        }
        return true;
    }

    private void sendMessage(String message) {
        if (mAppService != null) {
            if (mAppService.getState() != BluetoothAppService.STATE_CONNECTED) {
                ConnectBluetooth();
                return;
            }
        } else {
            ConnectBluetooth();
            return;
        }
        // Check that there's actually something to send
        if (message.length() > 0) {
            // Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            // Get the message bytes and tell the BluetoothChatService to write
            byte[] send = null;
            try {
                send = message.getBytes("KSC5601");
                // Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.i(TAG, message);
            mAppService.write(send);
        }
    }

    private void setupChat() {
        Log.d(TAG, "setupChat()");

        // Initialize the BluetoothChatService to perform bluetooth connections

        mAppService = new BluetoothAppService(this, mHandler);

    }

    protected void ConnectBluetooth() {
        bluetoothOn();
        // 리스트로 보냄
        Intent serverIntent = new Intent(this, DeviceListActivity.class);
        startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {

            case REQUEST_CONNECT_DEVICE:
                // When DeviceListActivity returns with a device to connect
                if (resultCode == Activity.RESULT_OK) {
                    // Get the device MAC address
                    String address = data.getExtras().getString(
                            DeviceListActivity.EXTRA_DEVICE_ADDRESS);
                    // Get the BLuetoothDevice object
                    BluetoothDevice device = mBluetoothAdapter
                            .getRemoteDevice(address);
                    // Attempt to connect to the device
                    mAppService.connect(device);
                }
                break;

            case REQUEST_ENABLE_BT:
                // When the request to enable Bluetooth returns
                if (resultCode == Activity.RESULT_OK) {
                    // Bluetooth is now enabled, so set up a chat session
                    setupChat();
                } else {
                    // User did not enable Bluetooth or an error occured
                    Log.d(TAG, "BT not enabled");
                    finish();
                }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:

                Send(String.valueOf(mEditText.getText()));
                break;
            case R.id.scan_btn:
                ConnectBluetooth();
                break;
        }

    }

}
