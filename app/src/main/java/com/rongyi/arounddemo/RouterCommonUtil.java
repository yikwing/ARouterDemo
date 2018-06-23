package com.rongyi.arounddemo;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by rongyi on 2017/7/26.
 */

public class RouterCommonUtil {


    public static void startMainActivity(final Activity activity) {
        ARouter.getInstance().build("/ui/主页").navigation(activity, new AbstractInterruptCallback() {
            @Override
            public void onInterrupt(Postcard postcard) {
                toastInterruptInfo(activity, postcard);
            }
        });
    }

    private static void toastInterruptInfo(final Activity activity, final Postcard postcard) {
        if (postcard.getTag() != null && postcard.getTag() instanceof String) {

            Observable.create((ObservableOnSubscribe<String>)
                    e -> e.onNext((String) postcard.getTag()))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                        if (!TextUtils.isEmpty(s) && activity != null) {
                            Toast.makeText(activity, (String) postcard.getTag(), Toast.LENGTH_SHORT).show();
                        }
                    });

        }
    }

    public static void startMainTextActivity(final Activity activity, String value) {
        ARouter.getInstance().build("/ui/text").withString("arg1", value).navigation(activity, 1001, new AbstractInterruptCallback() {
            @Override
            public void onInterrupt(Postcard postcard) {
                toastInterruptInfo(activity, postcard);
            }
        });
    }

    public static void startMainImageActivity(final Activity activity, String value) {
        ARouter.getInstance().build("/ui/image")
                .withString("arg1", value).navigation(activity, new AbstractInterruptCallback() {
            @Override
            public void onInterrupt(Postcard postcard) {
                toastInterruptInfo(activity, postcard);
            }
        });
    }

    public static void startLibraryOneActivity(final Activity activity) {
        ARouter.getInstance().build("/libraryOne/主页")
                .navigation(activity, new AbstractInterruptCallback() {
                    @Override
                    public void onInterrupt(Postcard postcard) {
                        toastInterruptInfo(activity, postcard);
                    }
                });
    }

}
