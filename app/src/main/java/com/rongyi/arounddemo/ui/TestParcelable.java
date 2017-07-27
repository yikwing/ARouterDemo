package com.rongyi.arounddemo.ui;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rongyi on 2017/7/27.
 */

public class TestParcelable implements Parcelable {
    private String name;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    public TestParcelable() {
    }

    public TestParcelable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected TestParcelable(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<TestParcelable> CREATOR = new Parcelable.Creator<TestParcelable>() {
        @Override
        public TestParcelable createFromParcel(Parcel source) {
            return new TestParcelable(source);
        }

        @Override
        public TestParcelable[] newArray(int size) {
            return new TestParcelable[size];
        }
    };
}
