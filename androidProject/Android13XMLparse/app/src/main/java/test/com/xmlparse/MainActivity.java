package test.com.xmlparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XmlPullParserFactory factory = null;
        try {
            // xml parsing을 위한 3종 세트
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            // String을 바로 담으면 안 되고 읽어주는 StringReader를 통해 보낸다.
            // setInput이 정보를 다 담고
            xpp.setInput( new StringReader( "<foo><aaa>yangssem!</aaa><aaa>yangssem!</aaa></foo>" ) );
            int eventType = xpp.getEventType();
            // 각각의 태그(START_TAG 등)를 이용해 정보를 쏙쏙 뽑아낸다
            while (eventType != XmlPullParser.END_DOCUMENT) {   // 문서가 다 끝날 때까지 돌린다
                if(eventType == XmlPullParser.START_DOCUMENT) {
                    System.out.println("Start document");
                } else if(eventType == XmlPullParser.START_TAG) {        // <>
                    System.out.println("Start tag "+xpp.getName());
                } else if(eventType == XmlPullParser.END_TAG) {         // </>
                    System.out.println("End tag "+xpp.getName());
                } else if(eventType == XmlPullParser.TEXT) {
                    System.out.println("Text "+xpp.getText());
                }
                eventType = xpp.next();     // 타입 - 분기 - next의 구조
            }
            System.out.println("End document");


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
