package com.example.lenovo.myapplication2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.Attributes;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
    public void outFile(View view){
        try {
            String file_name = "1.txt";
            CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
            int type = checkBox.isChecked() ? Context.MODE_APPEND : Context.MODE_PRIVATE;
            FileOutputStream ofo = openFileOutput("file_name", type);
            ofo.write(((EditText) findViewById(R.id.editText1)).getText().toString().getBytes());
            ofo.flush();
            ofo.close();
        }catch (IOException e){

        }
    }

    public void inFile(View view) throws IOException {
        try {
            FileInputStream ofi = openFileInput("file_name");
            int available = ofi.available();
            byte[] bytes = new byte[available];
            if (ofi.read(bytes) != -1) {
                ((TextView) findViewById(R.id.textView1)).setText(new String(bytes));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}

