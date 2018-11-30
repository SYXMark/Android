package com.example.lenovo.myapplication5;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Button button = (Button)findViewById(R.id.button);
        final EditText editText = (EditText)findViewById(R.id.editText1);
        final EditText editText2 = (EditText)findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    public void run(){
                        try{
                            URL url = new URL("http://192.168.22.2:8080/test/login");
                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                            String name = editText.getText().toString();
                            String password = editText2.getText().toString();
                            urlConnection.setRequestMethod("POST");
                            urlConnection.setConnectTimeout(5*1000);
                            String body = "name=" + URLEncoder.encode(name,"utf-8") + "&pass" + URLEncoder.encode(password,"utf-8");
                            urlConnection.setDoOutput(true);
                            urlConnection.getOutputStream().write(body.getBytes());
                            if(urlConnection.getResponseCode()==200){
                                InputStream inputStream = urlConnection.getInputStream();
                                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                String temp;
                                while ((temp = bufferedReader.readLine()) !=null){
                                    Log.i("结果",temp);
                                }
                                bufferedReader.close();
                                inputStreamReader.close();
                                inputStream.close();
                            }
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
        });
    }
}
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/
