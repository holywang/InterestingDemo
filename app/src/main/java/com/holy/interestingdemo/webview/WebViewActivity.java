package com.holy.interestingdemo.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.holy.interestingdemo.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private EditText webPageInput;
    private Button webPageGo;

    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        setView();
        setDefault();
        setListener();

    }

    private void setView(){
        webView = findViewById(R.id.web_page);
        webPageInput = findViewById(R.id.web_page_input);
        webPageInput.setText("http://a1.7x24cc.com/phone_webChat.html?accountId=N000000012654&chatId=jyrk-c3b09080-0239-11e8-8d92-53e98e57fe75&nickName=15541548809");
        webPageGo = findViewById(R.id.web_page_go);
    }

    private void setDefault(){
        webView.setWebChromeClient( new MyChromeClient (this));
        webView.loadUrl("www.baidu.com");
        webSettings = webView.getSettings();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    private void setListener(){
        webPageGo.setOnClickListener(view->{
            if (!webPageInput.getText().toString().equals("")) {
                webView.loadUrl(webPageInput.getText().toString());
            }
        });
    }

}
