package connectivitymanager.com.test.android20connectivitymanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    private TextView networkState;   //네트웍 상태표시용
    private EditText networkInfo;   //네트웍 정보표시용
    private ConnectivityManager connMgr; //시스템서비스를 얻어서 연결
    private NetworkInfo[] niArray;   //// 사용가능한 네트워크 파악용
    private String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        networkState = (TextView) findViewById(R.id.TextView01);
        networkInfo = (EditText) findViewById(R.id.EditText01);


        str = "";
        connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);


        niArray = connMgr.getAllNetworkInfo();
        for (NetworkInfo n : niArray) {
            str = str.concat(n.toString() + "\n\n");
        }
        networkInfo.setText(str);


    }//end onCreate()

    @Override
    protected void onStart() {
        super.onStart();
        //앱이 종료되지 않은 상태일때에도 네트워크 상태를 체크할 수 있도록
        //onStart()에 정의
        NetworkInfo ni = connMgr.getActiveNetworkInfo();
        if (ni != null) {
            if (connMgr.getActiveNetworkInfo().isAvailable()) {
            /*주의 : ni가 널값이 아닌경우(즉,무선네트워크 연결가능시)에만
				                 조건식에서 체크가능이 성립된다.*/
                String type = connMgr
                        .getActiveNetworkInfo().getTypeName();
                Log.i("Main Log", type);//WIFI,Wifi,wifi
                if (type.equalsIgnoreCase("mobile")) {
                    networkState.setText(
                            "현재 연결 네트워크  : 3G/4G/LTE무선 데이터 망" + "(" + type + ")");
                } else if (type.equalsIgnoreCase("wifi")) {
                    networkState.setText("현재 연결 네트워크  : " + type);
                }
                //사용중인 네트워크 정보 EditText로 출력
                str += ("getActiveNetworkInfo : \n"
                        + ni.toString() + "\n");
                networkInfo.setText(str + ">>>"
                        + ni.getState().toString());

                new Thread(){
                    @Override
                    public void run() {
                        doProcess();
                    }
                }.start();


            }
        } else {
            networkState.setText("무선네트워크 연결 실패");
        }
    }//end onStart()


    private void doProcess(){

        try{
            URL url = new URL("https://www.google.co.kr/images/srpr/logo11w.png");
            HttpURLConnection conn =
                    (HttpURLConnection)url.openConnection();

            Log.i("Main Log",
                    "conn.getResponseCode() : "+
                            conn.getResponseCode());

            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                Log.i("Main Log",
                        "conn.getContentType() : "+
                                conn.getContentType());
                if(conn.getContentType().startsWith("image/")){
                    Log.i("Main Log","이미지~~~맞거든~");
                }
            }


        }catch(Exception ex){
            Log.i("Main Log",ex.toString());
        }finally{

        }


    }//end doProcess()


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
