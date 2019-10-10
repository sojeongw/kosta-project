package com.test.android08lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("testlog","onCreate...");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("testlog","onStart..."+System.currentTimeMillis());
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("testlog","onResume...");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("testlog","onPause...");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("testlog","onSaveInstanceState...");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("testlog","onRestoreInstanceState...");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("testlog","onStop...");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("testlog", "onDestroy...");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("testlog", "onRestart...");
    }
}   // end of class
