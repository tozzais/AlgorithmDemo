package com.xmm.rpc1.message_communication;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MessengerService extends Service {
    public static final String TAG = "wangshu";

    public static final int MSG_FROMCLIENT=1000;

    private  Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MSG_FROMCLIENT:
                    Log.i(TAG,"收到客户端信息-------"+msg.getData().get("msg"));
                    //服务端发消息到 客户端
                    Messenger messenger = msg.replyTo;
                    Message mMessage=Message.obtain(null,MessengerService.MSG_FROMCLIENT);
                    Bundle mBundle=new Bundle();
                    mBundle.putString("rep","这里是服务端，我们收到信息了");
                    mMessage.setData(mBundle);
                    try {
                        messenger.send(mMessage);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"MessengerService---创建了");
        return new Messenger(handler).getBinder();
    }
}
