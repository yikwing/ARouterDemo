package com.rongyi.arounddemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.rongyi.arounddemo.GlideCircleTransform;
import com.rongyi.arounddemo.R;

/**
 * Created by rongyi on 2017/7/26.
 */

@Route(path = "/ui/image", group = "图片")
public class ImageActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        mImageView = (ImageView) findViewById(R.id.image_photo);

        String url = getIntent().getStringExtra("arg1");
        if (!TextUtils.isEmpty(url)) {
            Glide.with(this)
                    .load(url)
                    .transform(new GlideCircleTransform(this))
                    .into(mImageView);
        }

    }
}
