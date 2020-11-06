package com.xmm.firstcode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");

        findViewById(R.id.tv).setOnClickListener(view -> {
            start();
        });

        findViewById(R.id.tv_start).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,DialogActivity.class));
        });
    }

    private void start(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        ArrayList<ParcelableTest1> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new ParcelableTest1("123","123","123"));
        }
        intent.putExtra("123",list);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}