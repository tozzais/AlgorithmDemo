package com.xmm.firstcode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    private static final String TAG = "Second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ArrayList<Parcelable> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("123");

        Log.e(TAG, "onCreate"+parcelableArrayListExtra.size());
        findViewById(R.id.tv).setOnClickListener(v -> {
            try {
                start();
            }catch (Exception e){
                Log.e(TAG,e.getLocalizedMessage());
            }

        });
    }
    private void start(){
        Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
        ArrayList<ParcelableTest1> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ParcelableTest1 parcelableTest1 = new ParcelableTest1("123", "123", "123");
            list.add(parcelableTest1);
        }
        intent.putParcelableArrayListExtra("123",list);
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