package com.rongyi.arounddemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.aitangba.swipeback.SwipeBackActivity;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.rongyi.arounddemo.R;

/**
 * Created by rongyi on 2017/7/26.
 */

@Route(path = "/ui/image")
public class ImageActivity extends SwipeBackActivity {

    private ImageView mImageView;

    @Autowired
    String imgUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ARouter.getInstance().inject(this);


        mImageView = findViewById(R.id.image_photo);


        if (!TextUtils.isEmpty(imgUrl)) {
            Glide.with(this)
                    .load(imgUrl)
                    .into(mImageView);
        }

    }
}
