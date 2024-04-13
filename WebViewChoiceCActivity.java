package com.example.mobileclickersystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.content.Intent;
import android.view.View;

public class WebViewChoiceCActivity extends AppCompatActivity {
    private WebView webView;  // for displaying web contents
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_choice_aactivity);

        webView = (WebView) findViewById(R.id.webView);
        //webView.getSettings().setJavaScriptEnabled(true);

        // URL hardcoded
        webView.loadUrl("https://www.google.com");
        //webView.loadUrl("http://10.0.2.2:9999/mobile_clicker_system/select?choice=a");  // Your Tomcat's (localhost:9999) hello app
        // 10.0.2.2 is the special IP for the host machine of the emulator.
        //webView.loadUrl("http://ip_addr:port/hello/sayhello");   // Your Tomcat's hello app
    }
    // Method to handle the back button click
    public void btnBackHandler(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();  // Optionally finish this activity
    }
}