package com.example.mobileclickersystem;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // use "res/layout/activity_main.xml"
    }
    /** Callback when the user click the "HEART" button */
    public void btnHeartHandler(View view) {
        // Create an Intent to start the second activity called "WebViewActivity"
        Intent intent = new Intent(this, WebViewChoiceAActivity.class);
        // Start the intended activity
        startActivity(intent);
    }
    /** Callback when the user click the "STAR" button **/
    public void btnStarHandler(View view) {
        // Create an Intent to start the second activity called "WebViewActivity"
        Intent intent = new Intent(this, WebViewChoiceBActivity.class);
        // Start the intended activity
        startActivity(intent);
    }
    /** Callback when the user click the "CIRCLE" button **/
    public void btnCircleHandler(View view) {
        // Create an Intent to start the second activity called "WebViewActivity"
        Intent intent = new Intent(this, WebViewChoiceCActivity.class);
        // Start the intended activity
        startActivity(intent);
    }
    /** Callback when the user click the "SMILEY" button **/
    public void btnSmileyHandler(View view) {
        // Create an Intent to start the second activity called "WebViewActivity"
        Intent intent = new Intent(this, WebViewChoiceDActivity.class);
        // Start the intended activity
        startActivity(intent);
    }
}