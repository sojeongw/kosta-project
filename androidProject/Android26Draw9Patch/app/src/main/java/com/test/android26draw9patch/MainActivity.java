package com.test.android26draw9patch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast t = new Toast(this);
        t.setGravity(Gravity.TOP, 0, 0);
        t.setDuration(Toast.LENGTH_LONG);
        TextView tv = new TextView(this);
        tv.setTextSize(20.0f);
        tv.setText("Large Textaaaaaaaaaaaa\naaaaaa\naaaaaa");
        tv.setBackgroundResource(
                R.drawable.img02);
        t.setView(tv);
        t.show();

        Toast t2 = new Toast(this);
        t2.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
        t2.setDuration(Toast.LENGTH_LONG);
        TextView tv2 = new TextView(this);
        tv2.setTextSize(20.0f);
        tv2.setText("Large Textaaaaaaaaaaaa\naaaaaa\naaaaaa");
        tv2.setBackgroundResource(
                R.drawable.img02_9);
        t2.setView(tv2);
        t2.show();


    }


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
