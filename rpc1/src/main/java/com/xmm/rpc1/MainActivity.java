package com.xmm.rpc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.xmm.rpc1.message_communication.MessengerService;

/**
 * 进程间通信
 * Messenger
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "wangshu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MessengerService.class);
                bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("msg","这里是客户端，发送了消息");
                    message.setData(bundle);
                    mMessenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    private Messenger mMessenger;
    private Message message;
    ServiceConnection mServiceConnection =  new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMessenger = new Messenger(service);
            Log.i(TAG,"服务绑定成功");
            message = Message.obtain(null, MessengerService.MSG_FROMCLIENT);
            Bundle bundle = new Bundle();
            bundle.putString("msg","这里是客户端，发送了消息");
            message.setData(bundle);
            //将Messenger传递给服务端
            message.replyTo=new Messenger(mHandler);
            try {
                mMessenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MessengerService.MSG_FROMCLIENT:
                    Log.i(MessengerService.TAG, "收到服务端信息-------" + msg.getData().get("rep"));
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }
}
