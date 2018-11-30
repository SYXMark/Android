package com.example.lenovo.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends Activity {
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    private CheckBox checkBox;
    private CheckBox checkBox1;
    private CheckBox checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button) findViewById(R.id.button5);
        editText = (EditText) findViewById(R.id.editText7);
        editText1 = (EditText) findViewById(R.id.editText8);
        editText2 = (EditText)findViewById(R.id.editText2);
        radioButton = (RadioButton)findViewById(R.id.radioButton);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox1 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);

                intent.putExtra("usename", editText.getText().toString());
                intent.putExtra("password", editText1.getText().toString());
                intent.putExtra("sex",radioButton.getText().toString());
                intent.putExtra("hobby",checkBox.getText().toString());
                /*if(editText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"请输入密码！",Toast.LENGTH_LONG).show();
                    return;
                }
                if(editText2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"请确认密码！",Toast.LENGTH_LONG).show();
                    return;
                }
                if(editText.getText().toString()!=editText2.getText().toString()){
                    Toast.makeText(getApplicationContext(),"密码不一致！",Toast.LENGTH_LONG).show();
                    return;
                }
                if(radioButton.getText().toString().equals("")&&radioButton2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"请填写性别！",Toast.LENGTH_LONG).show();
                    return;
                }
                if(checkBox.getText().toString().equals("")&&checkBox1.getText().toString().equals("")&&checkBox2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"请填写至少一个爱好！",Toast.LENGTH_LONG).show();
                    return;
                }*/


                /*String hobby1 = "";
                intent.putExtra("hobby",hobby1);*/
                /*String sex1 = "";
                for (int i = 0; i < sex.getChildCount(); i++) {
                    RadioButton radioButton1 = (RadioButton) sex.getChildAt(i);
                    if (radioButton1.isChecked()) {
                        sex1 = radioButton1.getText().toString();
                        break;
                    }
                }
                intent.putExtra("sex",sex1);*/
                startActivity(intent);
            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   /*public void sendMessage1(View view) {
        Intent disIntent = new Intent(Main2Activity.this, Main5Activity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        final RadioGroup sex = (RadioGroup) findViewById(R.id.radioGroup);
        disIntent.putExtra("usename", editText.getText().toString());
        disIntent.putExtra("password", editText2.getText().toString());
        String sex1 = "";
        for (int i = 0; i < sex.getChildCount(); i++) {
            RadioButton radioButton1 = (RadioButton) sex.getChildAt(i);
            if (radioButton1.isChecked()) {
               sex1 = radioButton1.getText().toString();
               break;
            }
        }
        disIntent.putExtra("sex",sex1);
        startActivity(disIntent);
    }*/
    /*public void sendMessage2(View view) {
        Intent disIntent = new Intent(Main2Activity.this, Main4Activity.class);
        EditText editText = (EditText) findViewById(R.id.editText7);
        EditText editText2 = (EditText) findViewById(R.id.editText8);
        disIntent.putExtra("usename", editText.getText().toString());
        disIntent.putExtra("password", editText2.getText().toString());
        startActivity(disIntent);
    }*/

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




}
