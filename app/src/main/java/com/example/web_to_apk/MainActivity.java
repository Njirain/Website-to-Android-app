package com.example.web_to_apk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare needed variables
    private WebView webView;
    private WebSettings settings;
    String your_site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadView();
    }
    public void loadView(){
        //casting
        webView = (WebView) findViewById(R.id.web);
        settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //pass in your site's url in herein my case I just type google
        your_site = "http://google.com";
        webView.loadUrl(your_site);
        //correct the urls opening in browser issue
        webView.setWebViewClient(new WebViewClient());
    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Option doesn't have advanced functionality",Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"second item doesn't have much too for now",Toast.LENGTH_LONG)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}