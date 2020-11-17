package com.czy.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.czy.server.Book;
import com.czy.server.BookController;

import java.util.List;

/**
 * https://www.jianshu.com/p/29999c1a93cd
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_getBookList).setOnClickListener(this);
        findViewById(R.id.btn_addBook_inOut).setOnClickListener(this);
        findViewById(R.id.btn_addBook_In).setOnClickListener(this);
        findViewById(R.id.btn_addBook_Out).setOnClickListener(this);
        bindService();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getBookList:

                if (connected) {
                    try {
                        bookList = bookController.getBookList();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    log();
                }
                break;
            case R.id.btn_addBook_inOut:
                if (connected) {
                    Book book = new Book("这是一本新书 InOut");
                    try {
                        bookController.addBookInOut(book);
                        Log.e(TAG, "向服务器以InOut方式添加了一本新书");
                        Log.e(TAG, "新书名：" + book.getName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btn_addBook_In:
                if (connected) {
                    Book book = new Book("这是一本新书 In");
                    try {
                        bookController.addBookIn(book);
                        Log.e(TAG, "向服务器以In方式添加了一本新书");
                        Log.e(TAG, "新书名：" + book.getName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btn_addBook_Out:
                if (connected) {
                    Book book = new Book("这是一本新书 Out");
                    try {
                        bookController.addBookOut(book);
                        Log.e(TAG, "向服务器以Out方式添加了一本新书");
                        Log.e(TAG, "新书名：" + book.getName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setPackage("com.czy.server");
        intent.setAction("com.czy.server.action");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        Log.e(TAG, "绑定服务" );
    }

    private final String TAG = "Client";

    private BookController bookController;

    private boolean connected;

    private List<Book> bookList;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceConnected" );
            bookController = BookController.Stub.asInterface(service);
            connected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "onServiceDisconnected" );
            connected = false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connected) {
            unbindService(serviceConnection);
        }
    }

    private void log() {
        for (Book book : bookList) {
            Log.e(TAG, book.toString());
        }
    }
}
