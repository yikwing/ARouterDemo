package com.rongyi.arounddemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rongyi.arounddemo.R;

import java.util.Date;

/**
 * Created by rongyi on 2017/7/26.
 */

@Route(path = "/ui/text")
public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        String str = getIntent().getStringExtra("name");
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
