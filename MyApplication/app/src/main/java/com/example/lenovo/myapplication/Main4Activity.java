package com.example.lenovo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main4Activity extends Activity {
    private Intent showIntent2;
    private TextView showtext;
    private TextView showtext2;
    private TextView showtext3;
    private TextView showtext4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        showIntent2 = getIntent();
        String messageString = showIntent2.getStringExtra("usename");
        String messageString2 = showIntent2.getStringExtra("password");
        String messageString3 = showIntent2.getStringExtra("sex");
        String messageString4 = showIntent2.getStringExtra("hobby");
        showtext = (TextView)findViewById(R.id.textView13);
        showtext2 = (TextView)findViewById(R.id.textView15);
        showtext3 = (TextView)findViewById(R.id.textView17);
        showtext4 = (TextView)findViewById(R.id.textView19);
        showtext.setText(messageString);
        showtext2.setText(messageString2);
        showtext3.setText(messageString3);
        showtext4.setText(messageString4);
        /*Button button = (Button)findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*SharedPreferences spf = getSharedPreferences("jk_text",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = spf.edit();
                editor.putString("text first","valuestring");
                editor.apply();
                Log.i("读取文件 jk_text",spf.getString("text","defvalue"));*/
                /*try{
                    FileInputStream fis = openFileInput("file_out");
                    byte[] bytes = new byte[fis.available()];
                    while(fis.read(bytes)!=-1){
                        Log.i("文件读取结果：",new String(bytes));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try{
                    FileOutputStream fos = openFileOutput("file_out",Context.MODE_APPEND);
                    fos.write("add text".getBytes());
                    fos.flush();
                    fos.close();




                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
