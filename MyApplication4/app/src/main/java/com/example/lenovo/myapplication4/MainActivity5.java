package com.example.lenovo.myapplication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Button btn= (Button) findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //两个参数：第一个参数：结果码第二个Intent,
                Intent intent=getIntent();//接受上个activity发送过来的intent
                CheckBox box1=(CheckBox) findViewById(R.id.pro1);
                CheckBox box2=(CheckBox) findViewById(R.id.pro2);
                CheckBox box3=(CheckBox) findViewById(R.id.pro3);
                CheckBox box4=(CheckBox) findViewById(R.id.pro4);
                String proName="";
                proName+=box1.isChecked()? box1.getText()+" ":"";
                proName+=box2.isChecked()? box2.getText()+" ":"";
                proName+=box3.isChecked()? box3.getText()+" ":"";
                proName+=box4.isChecked()? box4.getText()+" ":"";
                intent.putExtra("pro",proName);
//关键代码
                setResult(RESULT_OK,intent);
                finish();//结束activity
            }
        });
    }

}
