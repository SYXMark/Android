package com.example.lenovo.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class MainActivity3 extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private TextView textView;
    private SQLiteDatabase db;
    Integer id = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        textView = (TextView)findViewById(R.id.textView);
        //创建数据库
        db = openOrCreateDatabase(
                "first.db",
                Context.MODE_PRIVATE,
                null);
        db.execSQL("create table if not exists vocabulary(id integer primary key autoincrement,English varchar(30),Chinese varchar(30))");
        button.setOnClickListener(new View.OnClickListener() {
            //插入数据
            @Override
            public void onClick(View v) {
                //点击插入事件
                if(editText.getText().toString().equals("")||editText2.getText().toString().equals("")){
                    //弹框提示
                    Toast.makeText(getApplicationContext(),"请填写插入内容！",Toast.LENGTH_LONG).show();
                    return;
                }
                String English = editText.getText().toString();
                String Chinese = editText2.getText().toString();
                String sql = "insert into vocabulary(English,Chinese) values('"+English+"','"+Chinese+"')";
                db.execSQL(sql);
                Toast.makeText(getApplicationContext(),"插入成功！",Toast.LENGTH_LONG).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            //查找数据
            @Override
            public void onClick(View v) {
                //点击查询事件
                //Cursor cursor = db.query("vocabulary","English",null,null,null,null,null);
                    String voc = editText3.getText().toString();
                    String English = "";
                    String Chinese = "";
                Cursor cursor = db.query("vocabulary",null,null,null,null,null,null);
                    while (cursor.moveToNext()){
                        if(voc.equals(cursor.getString(1))||voc.equals(cursor.getString(2))){
                            English = cursor.getString(1);
                            Chinese = cursor.getString(2);
                        }
                        textView.setText(English+","+Chinese);
                        //Toast.makeText(getApplicationContext(),English+","+Chinese,Toast.LENGTH_LONG).show();
                    }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            //删除数据
            @Override
            public void onClick(View v) {
                //点击删除事件
                String delete = editText3.getText().toString();
                db.execSQL("delete from vocabulary where English = '"+delete+"'");
                db.execSQL("delete from vocabulary where Chinese = '"+delete+"'");
                Toast.makeText(getApplicationContext(),"删除成功",Toast.LENGTH_LONG).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            //修改数据
            @Override
            public void onClick(View v) {
                //点击修改事件
                String English2 = editText.getText().toString();
                String Chinese2 = editText2.getText().toString();
                String EC = editText3.getText().toString();
                Cursor cursor = db.query("vocabulary",null,null,null,null,null,null);
                while (cursor.moveToNext()){
                    if(cursor.getString(1).equals(EC)||cursor.getString(2).equals(EC)){
                        id = cursor.getInt(0);
                        break;
                    }
                }
                if(id == -1){
                    return;
                }
                db.execSQL("update [vocabulary] set Chinese = '"+Chinese2+"' where id = "+id);
                db.execSQL("update [vocabulary] set English = '"+English2+"' where id = "+id);
                if(editText.getText().toString().equals("")||editText2.getText().toString().equals("")){
                    //弹框提示
                    Toast.makeText(getApplicationContext(),"请填写修改内容！",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    textView.setText(English2+Chinese2);
                    //Toast.makeText(getApplicationContext(),English2+","+Chinese2,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}


