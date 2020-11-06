package com.xmm.firstcode;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableTest1 implements Parcelable {
    public String name;
    public String sex;
    public String age;

    public ParcelableTest1(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.sex);
        dest.writeString(this.age);
    }

    public ParcelableTest1() {
    }

    protected ParcelableTest1(Parcel in) {
        this.name = in.readString();
        this.sex = in.readString();
        this.age = in.readString();
    }

    public static final Creator<ParcelableTest1> CREATOR = new Creator<ParcelableTest1>() {
        @Override
        public ParcelableTest1 createFromParcel(Parcel source) {
            return new ParcelableTest1(source);
        }

        @Override
        public ParcelableTest1[] newArray(int size) {
            return new ParcelableTest1[size];
        }
    };
}
