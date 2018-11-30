package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent showintent = getIntent();
        String messageString3 = showintent.getStringExtra("usename");
        String messageString4 = showintent.getStringExtra("password");
        TextView showtxt3 = (TextView)findViewById(R.id.textView10);
        TextView showtxt4 = (TextView)findViewById(R.id.textView11);
        showtxt3.setText(messageString3);
        showtxt4.setText(messageString4);
        /*Bundle bundle = showintent.getExtras();
        bundle.getString("usename");
        bundle.getString("password");
        */

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
