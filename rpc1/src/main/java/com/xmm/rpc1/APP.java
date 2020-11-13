package com.xmm.rpc1;

import android.app.Application;
import android.util.Log;


public class APP extends Application {
    private static final String TAG = "wangshu";

    @Override
    public void onCreate() {
        super.onCreate();
        int pid = android.os.Process.myPid();
        Log.i(TAG, "MyApplication is oncreate====="+"pid="+pid);
    }
}
