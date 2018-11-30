package com.example.lenovo.myapplication4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity4 extends AppCompatActivity {
    Button proText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        proText= (Button) findViewById(R.id.btn);
        proText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity4.this,MainActivity5.class);
                //关键代码
                startActivityForResult(intent,0);
            }
        });
    }
    //关键代码，重写这个方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断请求码和结果码
        if(requestCode==0&&resultCode==RESULT_OK){
            //获取从商品页面返回的商品信息
            String  proName=data.getStringExtra("pro");

            proText.setText(proName);

        }
    }

}
