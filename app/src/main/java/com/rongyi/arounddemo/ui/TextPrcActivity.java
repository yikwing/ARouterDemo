package com.rongyi.arounddemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rongyi.arounddemo.R;

/**
 * Created by rongyi on 2017/7/26.
 */

@Route(path = "/ui/textprc")
public class TextPrcActivity extends AppCompatActivity {


    @Autowired
    String name;

    @Autowired
    int age;

    @Autowired(name = "boy")
    boolean girl;

    @Autowired
    TestParcelable pac;


    private long high;

    @Autowired
    String url;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);


        ARouter.getInstance().inject(this);

        String params = String.format(
                "name=%s,\n age=%s,\n girl=%s,\n high=%s,\n url=%s,\n pac=%s",
                name,
                age,
                girl,
                high,
                url,
                pac
        );


        ((TextView)findViewById(R.id.textView)).setText(params);


    }

    /*@Override
    public void finish() {
        setResult(1002, getIntent().putExtra("arg2", new Date().toString()));
        super.finish();
    }*/

}
