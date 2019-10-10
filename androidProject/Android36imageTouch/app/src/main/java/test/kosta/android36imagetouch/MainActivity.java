package test.kosta.android36imagetouch;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    ViewTouchImage vti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vti = (ViewTouchImage) findViewById(R.id.draw);
        vti.setImageResource(R.drawable.layer);


//        Resources r = getResources();
//        Drawable[] layers = new Drawable[2];
//        layers[0] = r.getDrawable(R.drawable.map1);
////        layers[1] = r.getDrawable(R.drawable.btn_default_pressed);
//        LayerDrawable layerDrawable = new LayerDrawable(layers);
//        vti.setImageDrawable(layerDrawable);

    }
}
