package com.rongyi.arounddemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.rongyi.arounddemo.R;

import java.util.Date;

/**
 * Created by rongyi on 2017/7/26.
 */

@Route(path = "/ui/text", group = "文本")
public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        String str = getIntent().getStringExtra("arg1");
        if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(R.id.textView)).setText(str);
        }
    }

    @Override
    public void finish() {
        setResult(1002, getIntent().putExtra("arg2", new Date().toString()));
        super.finish();
    }

}
