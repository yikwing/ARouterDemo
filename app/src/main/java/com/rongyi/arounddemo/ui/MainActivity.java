package com.rongyi.arounddemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rongyi.arounddemo.OnLimitClickHelper;
import com.rongyi.arounddemo.R;
import com.rongyi.arounddemo.RouterCommonUtil;

@Route(path = "/ui/主页")
public class MainActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;

    private static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;

        mButton1 = findViewById(R.id.btn_click1);
        mButton2 = findViewById(R.id.btn_click2);
        mButton3 = findViewById(R.id.btn_click3);
        mButton4 = findViewById(R.id.btn_click4);
        mButton5 = findViewById(R.id.btn_click5);
        mButton6 = findViewById(R.id.btn_click6);
        mButton7 = findViewById(R.id.btn_click7);

        ActivityOptionsCompat compat = ActivityOptionsCompat.
                makeScaleUpAnimation(mButton4, mButton4.getWidth() / 2, mButton4.getHeight() / 2, 0, 0);


        mButton1.setOnClickListener(v ->
                ARouter.getInstance().build("/ui/text")
                        .withString("name", "老王普通")
                        .navigation(MainActivity.this, 1001));


        mButton2.setOnClickListener(new OnLimitClickHelper(view -> {
            String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1501055009&di=fdccde81138e0d51cc81432d849f103e&src=http://img.taopic.com/uploads/allimg/140326/235113-1403260U22059.jpg";
            RouterCommonUtil.startMainImageActivity(MainActivity.this, url);
        }));


        mButton3.setOnClickListener(v ->
                RouterCommonUtil.startLibraryOneActivity(MainActivity.this));

        mButton4.setOnClickListener(v -> {
            Uri testUriMix = Uri.parse("router://m.yikwing.com/ui/text");
            ARouter.getInstance().build(testUriMix).withString("name", "老张url")
                    .withOptionsCompat(compat).navigation();
        });


        mButton5.setOnClickListener(v -> {
            TestParcelable testParcelable = new TestParcelable("jack", 666);

            ARouter.getInstance().build("/ui/textprc")
                    .withString("name", "老王")
                    .withInt("age", 18)
                    .withBoolean("boy", true)
                    .withLong("high", 180)
                    .withString("url", "https://a.b.c")
                    .withParcelable("pac", testParcelable)
                    .navigation();
        });

        mButton6.setOnClickListener(new OnLimitClickHelper(view -> {
            Uri testUriMix = Uri.parse("router://m.yikwing.com/ui/urlPairms?name=tpnet&age=21&sex=true");
            ARouter.getInstance().build(testUriMix)
                    .navigation();
        }));


        mButton7.setOnClickListener(new OnLimitClickHelper(view -> {
            ARouter.getInstance().build("/ui/fragment").navigation();

        }));

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1002) {
            Toast.makeText(this, data.getStringExtra("arg2"), Toast.LENGTH_SHORT).show();
        }
    }


    public static Activity getThis() {
        return activity;
    }
}
