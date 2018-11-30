package com.example.lenovo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main5Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent showintent = getIntent();
        /*String messageString3 = showintent.getStringExtra("usename");
        String messageString4 = showintent.getStringExtra("password");
        TextView showtxt3 = (TextView)findViewById(R.id.textView10);
        TextView showtxt4 = (TextView)findViewById(R.id.textView11);
        showtxt3.setText(messageString3);
        showtxt4.setText(messageString4);*/

    }
    /*public void addTextView(View v){
        EditText editText = (EditText)findViewById(R.);
        editText.getText();

        try {
            FileOutputStream fos = openFileOutput("file_jk",Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/
    /*public void readTextView(View v){
        FileInputStream fis = openFileInput("file_jk");
        byte[] bytes = new byte[fis.available()];
        while(read){
            new String(bytes);
            TextView textView = ()f;

        }
    }

}*/
}