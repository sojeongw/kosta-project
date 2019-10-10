package test.com.jsonparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String txtJSON = "[{\"num\":99,\"name\":\"yang군\",\"math\":77,\"eng\":88,\"kor\":99},{\"num\":99,\"name\":\"yang군\",\"math\":77,\"eng\":88,\"kor\":99},{\"num\":99,\"name\":\"yang군\",\"math\":77,\"eng\":88,\"kor\":99}]";

        try {
            JSONArray array = new JSONArray(txtJSON);
            for(int i=0;i<array.length();i++){
                JSONObject obj = array.getJSONObject(i);
                int num = obj.getInt("num");
                String name = obj.getString("name");
                int kor = obj.getInt("kor");
                int eng = obj.getInt("eng");
                int math = obj.getInt("math");

                Log.i("MainActivity",num+":"+name+":"+kor+":"+eng+":"+math);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
