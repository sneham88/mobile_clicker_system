package com.example.mobile_clicker_system;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.testintent.MESSAGE";

    // ADD references to UI views
    private RadioButton radioBtnQ1, radioBtnQ2, radioBtnQ3, radioBtnQ4, radioBtnQ5;
    //private Button btnA, btnB, btnC, btnD;

    // REPLACE the entire onCreate() as follows:
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve references to UI views via their ID in XML layout
        radioBtnQ1   = (RadioButton) findViewById(R.id.radioButtonQ1);
        radioBtnQ2   = (RadioButton) findViewById(R.id.radioButtonQ2);
        radioBtnQ3   = (RadioButton) findViewById(R.id.radioButtonQ3);
        radioBtnQ4   = (RadioButton) findViewById(R.id.radioButtonQ4);
        radioBtnQ5   = (RadioButton) findViewById(R.id.radioButtonQ5);

        //btnA = (Button) findViewById(R.id.buttonA);
        //btnB = (Button) findViewById(R.id.buttonB);
        //btnC = (Button) findViewById(R.id.buttonC);
        //btnD = (Button) findViewById(R.id.buttonD);
    }

    public void choiceSelectHandler(View v) {
        // make the URL according to the question and choice selected
        String stringToPass, questionSelected, choiceSelected;
        questionSelected = "1";
        choiceSelected = "a";

        if (radioBtnQ1.isChecked()) { // choice is for Q1
            questionSelected = "1" ;
        } else if (radioBtnQ2.isChecked()) { // choice is for Q2
            questionSelected = "2" ;
        } else if (radioBtnQ3.isChecked()) { // choice is for Q3
            questionSelected = "3" ;
        } else if (radioBtnQ4.isChecked()) { // choice is for Q4
            questionSelected = "4" ;
        } else if (radioBtnQ5.isChecked()) { // choice is for Q5
            questionSelected = "5" ;
        }

        //if(btnA.isPressed()) {
        //}

        if(v.getId()==R.id.buttonA) {
            choiceSelected = "a";
        } else if(v.getId()==R.id.buttonB) {
            choiceSelected = "b";
        } else if(v.getId()==R.id.buttonC) {
            choiceSelected = "c";
        } else if(v.getId()==R.id.buttonD) {
            choiceSelected = "d";
        }

        // complete the URL and trigger it (without going to webpage)
        //urlToTrigger = "http://10.0.2.2:9999/mobile_clicker_system/response?questionNo=1&choice=a"
        //stringToPass = "http://10.0.2.2:9999/mobile_clicker_system/response?questionNo=" + questionSelected + "&choice=" + choiceSelected;
        stringToPass = questionSelected + choiceSelected;

        // Create an Intent to start the second activity called "WebViewActivity"
        Intent intent = new Intent(this, WebViewActivity.class);

        // Retrieve the message entered and put into the Intent
        intent.putExtra(EXTRA_MESSAGE, stringToPass);  // key-value pair
        startActivity(intent);

    }

}