package com.rongyi.arounddemo.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button) findViewById(R.id.btn_click1);
        mButton2 = (Button) findViewById(R.id.btn_click2);
        mButton3 = (Button) findViewById(R.id.btn_click3);
        mButton4 = (Button) findViewById(R.id.btn_click4);
        mButton5 = (Button) findViewById(R.id.btn_click5);
        mButton6 = (Button) findViewById(R.id.btn_click6);
        mButton7 = (Button) findViewById(R.id.btn_click7);

        ActivityOptionsCompat compat = ActivityOptionsCompat.
                makeScaleUpAnimation(mButton4, mButton4.getWidth() / 2, mButton4.getHeight() / 2, 0, 0);


        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RouterCommonUtil.startMainTextActivity(MainActivity.this, "测试文本");
                ARouter.getInstance().build("/ui/text")
                        .withString("name", "老王普通")
                        .navigation(MainActivity.this, new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {

                            }

                            @Override
                            public void onLost(Postcard postcard) {

                            }

                            @Override
                            public void onArrival(Postcard postcard) {

                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {

                            }
                        });
            }
        });

//        mButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1501055009&di=fdccde81138e0d51cc81432d849f103e&src=http://img.taopic.com/uploads/allimg/140326/235113-1403260U22059.jpg";
//                RouterCommonUtil.startMainImageActivity(MainActivity.this, url);
//            }
//        });

        mButton2.setOnClickListener(new OnLimitClickHelper(view -> {
            String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1501055009&di=fdccde81138e0d51cc81432d849f103e&src=http://img.taopic.com/uploads/allimg/140326/235113-1403260U22059.jpg";
            RouterCommonUtil.startMainImageActivity(MainActivity.this, url);
        }));


        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterCommonUtil.startLibraryOneActivity(MainActivity.this);
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri testUriMix = Uri.parse("router://m.yikwing.com/ui/text");
                ARouter.getInstance().build(testUriMix).withString("name", "老张url")
                        .withOptionsCompat(compat).navigation();
            }
        });


        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestParcelable testParcelable = new TestParcelable("jack", 666);

                ARouter.getInstance().build("/ui/textprc")
                        .withString("name", "老王")
                        .withInt("age", 18)
                        .withBoolean("boy", true)
                        .withLong("high", 180)
                        .withString("url", "https://a.b.c")
                        .withParcelable("pac", testParcelable)
                        .navigation();
            }
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
}
