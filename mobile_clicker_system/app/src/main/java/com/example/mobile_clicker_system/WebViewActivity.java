package com.example.mobile_clicker_system;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.content.Intent;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;  // for displaying web contents

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String questionAndChoice = "1a";
        // Get the message from the intent
        Intent intent = getIntent();
        questionAndChoice = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        String urlToTrigger = "http://10.0.2.2:9999/mobile_clicker_system/response?questionNo=" + questionAndChoice.charAt(0) + "&choice=" + questionAndChoice.charAt(1);

        webView = (WebView) findViewById(R.id.webView);
        //webView.getSettings().setJavaScriptEnabled(true);

        //webView.loadUrl("http://10.0.2.2:9999/mobile_clicker_system/response?questionNo=" + questionAndChoice.charAt(0) + "&choice=" + questionAndChoice.charAt(1)");
        webView.loadUrl(urlToTrigger);
        //webView.loadUrl("https://www.google.com");
        //webView.loadUrl("http://10.0.2.2:9999/hello/sayhello");  // Your Tomcat's (localhost:9999) hello app
        // 10.0.2.2 is the special IP for the host machine of the emulator.
        //webView.loadUrl("http://ip_addr:port/hello/sayhello");   // Your Tomcat's hello app
    }

    public void goBackHandler(View v) {
        //webView = (WebView) findViewById(R.id.webView);
        //webView.destroy();

        // Create an Intent to go back to "MainActivity"
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}