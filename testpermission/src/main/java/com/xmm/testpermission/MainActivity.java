package com.xmm.testpermission;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.tozzais.baselibrary.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    /**
     * 小米手机新建项目：读取应用列表 ，剪切板，媒体音量控制，桌面快捷，锁屏显示，后台弹出界面，常驻通知
     *
     *
     *
     */

    public static String[] needPermissions = {
            Manifest.permission.READ_SMS
    };
    @BindView(R.id.tv)
    TextView tv;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void loadData() {
        ActivityCompat.requestPermissions(this, needPermissions, 100);
    }


    @OnClick(R.id.tv)
    public void onViewClicked() {
        tv.setText(tv.getText().toString()+"1");
    }
}
