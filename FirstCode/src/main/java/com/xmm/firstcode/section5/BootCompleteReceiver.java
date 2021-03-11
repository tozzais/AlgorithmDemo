package com.xmm.firstcode.section5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
//接受开机广播
public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("onReceive","Boot Complete");
        Toast.makeText(context,"Boot Complete",Toast.LENGTH_LONG).show();
    }
}