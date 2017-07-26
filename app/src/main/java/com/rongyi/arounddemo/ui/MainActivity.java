package com.rongyi.arounddemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.rongyi.arounddemo.R;
import com.rongyi.arounddemo.RouterCommonUtil;

@Route(path = "/ui/主页")
public class MainActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button) findViewById(R.id.btn_click1);
        mButton2 = (Button) findViewById(R.id.btn_click2);
        mButton3 = (Button) findViewById(R.id.btn_click3);


        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterCommonUtil.startMainTextActivity(MainActivity.this, "测试文本");
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1501055009&di=fdccde81138e0d51cc81432d849f103e&src=http://img.taopic.com/uploads/allimg/140326/235113-1403260U22059.jpg";
                RouterCommonUtil.startMainImageActivity(MainActivity.this, url);
            }
        });


        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterCommonUtil.startLibraryOneActivity(MainActivity.this);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1002) {
            Toast.makeText(this, data.getStringExtra("arg2"), Toast.LENGTH_SHORT).show();
        }
    }
}
