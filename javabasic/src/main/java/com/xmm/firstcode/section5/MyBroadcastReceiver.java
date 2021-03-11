package com.xmm.firstcode.section5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("My1Receiver","接受到了");
        Toast.makeText(context,"received in My1Receiver",Toast.LENGTH_LONG).show();
    }
}