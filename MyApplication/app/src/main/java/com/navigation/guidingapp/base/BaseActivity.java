package com.navigation.guidingapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by jiayong-xiao on 2017/2/11.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 初始化布局
     */
    public abstract void initContentView();

    /**
     * 初始化控件
     */
    public abstract void initView();
    /**
     * 初始化监听
     */
    public abstract void initListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView();
        //初始化View注入
        ButterKnife.bind(this);
        initView();
        initListener();
    }


    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
