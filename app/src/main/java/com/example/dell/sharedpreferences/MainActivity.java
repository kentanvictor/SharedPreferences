package com.example.dell.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveData = (Button) findViewById(R.id.save_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 28);
                editor.putBoolean("married", false);
                editor.apply();
                /*
                * 点击事件通过getSharedPreferences()方法指定SharedPrefences的文件名为data。
                * 并得到SharedPreferences.Editor对象。
                * editor.putString、editor.putInt和editor.putBoolean添加了三个数据存储的工作
                * 最后使用editor.apply()的方法提交，完成数据存储的操作
                * */
            }
        });
        Button restoreData = (Button) findViewById(R.id.restore_data);
        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                //通过getSharedPreferences()方法得到SharedPreferences的对象
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                boolean married = pref.getBoolean("married", false);
                //分别调用getString、getInt和getBoolean方法获取前面储存的数据，如果没有找到数据，就用后面的默认值代替
                Log.d("MainActivity", "name is" + name);
                Log.d("MainActivity", "age is" + age);
                Log.d("MainActivity", "married is" + married);
                //最后通过Log.d()打印出来
            }
        });
    }
}
