package webview.com.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        Uri uri = Uri.parse("http://yangssem.blog.me");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);

        // 웹 페이지를 그대로 view 해주는 기능
        WebView webview = new WebView(this);
        webview.loadUrl("http://yangssem.blog.me");
//        webview.loadUrl("http://192.168.0.129:8090/web13ServletJSON/json_select2.do");


        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                MainActivity.this.setProgress(progress * 1000);
            }

        });

        // 아래가 핵심. 자바 스크립트에 의해 동적으로 할당하는 부분이 있다면 꼭 해줘야 한다.
        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(MainActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

        });

//        webview.loadUrl("http://bootstrapk.com/examples/jumbotron/");
//        getWindow().requestFeature(Window.FEATURE_PROGRESS);

        setContentView(webview);

    }
}
