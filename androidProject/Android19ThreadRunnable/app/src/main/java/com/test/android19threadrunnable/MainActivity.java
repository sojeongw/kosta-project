package com.test.android19threadrunnable;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AsyncTask atEx;
    Button btn_01;
    Button btn_02;
    Button btn_03;
    Button btn_04;
    Button btn_05;

    private TextView tv_txt;
    private ProgressDialog mProgressDialog;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_01 = (Button) findViewById(R.id.btn_01);
        btn_02 = (Button) findViewById(R.id.btn_02);
        btn_03 = (Button) findViewById(R.id.btn_03);
        btn_04 = (Button) findViewById(R.id.btn_04);
        btn_05 = (Button) findViewById(R.id.btn_05);

        tv_txt = (TextView)  findViewById(R.id.tv_txt);

        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog = mProgressDialog.show(MainActivity.this, "main title", "main message");
                // 방법 1. run 메소드 >> 이너클래스로
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            Log.i("MainActivity", "for 2..." + ((i + 1) * 10));
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        /* 에러는 안 났지만 에러가 날 수 있기 때문에 thread가 끝나는 시점에서
                         main에 있는 애한테 setText나 dismiss를 하려면 핸들링하는 쓰레드가 필요하다.
                         그 핸들링 하는 기능엔 post가 있다. 아직 블럭 끝을 만나지 않았으므로 끝난 건 아님.
                         postExecute에 setText해준 것처럼 여기서도 postExecute에 기능을 갖는 오브젝트를 구현해준 것.
                         = 핸들러
                         */
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                // 여기가 thread로 도는데 main에 관여할 수 있다.
                                tv_txt.setText("Thread 1..end for");
                                mProgressDialog.dismiss();
                                /*run이 thread를 다 돌고 나면 얘를 실행해서
                                Only original thread that created a view hierarchy can touch its views
                                라는 에러를 해결해준다. main thread에 관여해서 만들어주는 것. */
                            }
                        });
                    }
                }).start();
                // run은 runnable의 인터페이스를 상속받은 내부 클래스
            }
        });

        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 방법 2. anonymous inner class
                new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            Log.i("MainActivity", "for 3..." + ((i + 1) * 100));
                        }
                    }
                }.start();
                // start 메소드는 thread 안에만 있어서 thread거나 thread를 상속받았을 때만 사용 가능하다.
            }
        });

        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Test01().start();
                // run은 순차
            }
        });

        btn_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new RunnableImpl()).start();
        }
        });

        btn_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTaskEx().execute("aaa","bbb","ccc");
            }
        });

         /* java.lang에 있는 thread 객체
         new Thread();
         >> 객체만 생성한 것이지 쓰레드를 돌린 것은 아니다.
         thread라는 객체 안에 있는 run이라는 메소드를 오버라이딩 해서
         thread 돌으라고 명령을 해준 다음 구현해줘야 한다.
         thread 실행 >> new Thread().start(); */

         Log.i("testLog", "onCreate 03...");

    }   // onCreate()

    ////////////////////////////////////////////////////////

    // 3. Thread를 상속받는 클래스를 만들어서 스레드 구현할 것
    // a~z
    public class Test01 extends Thread{

        @Override
        public void run() {
            for (char i = 'a'; i < 'z'; i++) {
                Log.i("MainActivity", "for 4..." + i);
            }
        }
    }

    // 4. runnable를 상속받는 클래스를 만들어서 스레드 구현할 것
    // a0~a9 출력하는 실행문 구현
    public class RunnableImpl implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.i("RunnableImpl", "a" + i);
            }
        }
    }


    // 5. AsyncTask를 상속받는 클래스를 만들어서 스레드 구현하기
    public class AsyncTaskEx extends AsyncTask<String, Integer, String>{
        // 제네릭을 표시하지 않으면 object 타입으로 override 된다
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            Log.i("AsyncTaskEx", "onPreExecute()...");
            progressDialog = ProgressDialog.show(MainActivity.this, "title", "message");
            // on post execute에서 dismiss까지 해줘야 계속 돌지 않는다.
        }

        @Override
        protected String doInBackground(String... params) {
            Log.i("AsyncTaskEx", "doInBackground()..." + params[0]);
            for (int i = 0; i < params.length; i++) {
                Log.i("AsyncTaskEx", "doInBackground()..." + params[i]);

                try {
                    Thread.sleep(1000);
                    publishProgress(111, 222, 999); // call the onProgressUpdate(); setText 중간 확인 가능
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // publishProgress(111, 222, 999);
            // 여기에 있어도 됨 >> setText가 제일 마지막에 된 값만 출력된다.
            return null;
        }

        @Override
        protected void onPostExecute(String str) {
            atEx = null;    // 자동으로 됐으면 null 처리해

            // str에는 doInBackground의 return 값이 들어가기 때문에 타입이 일치해야 한다.
            Log.i("AsyncTaskEx", "onPostExecute()..." + str);

            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... sus) {
            // sus에 111, 222, 999 가 온다
            Log.i("AsyncTaskEx", "onProgressUpdate()..." + sus);

            for(Integer su: sus){
                Log.i("AsyncTaskEx", "onProgressUpdate()..." + su);
                tv_txt.setText("KIM..." + su.toString());
            }

        }

        @Override
        protected void onCancelled() {
            atEx = null;
        }
    }   //


}   // class
