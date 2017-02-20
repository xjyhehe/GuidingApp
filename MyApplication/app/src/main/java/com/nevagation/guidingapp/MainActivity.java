package com.nevagation.guidingapp;

import android.os.Bundle;
import android.view.View;

import com.nevagation.guidingapp.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ib_video,R.id.ib_navigate,R.id.ib_update,R.id.ib_setting})
    public void buttonClick(View v){
        switch (v.getId()){
            case R.id.ib_video:
                //视频录像
                break;
            case R.id.ib_navigate:
                //导航
                break;
            case R.id.ib_update:
                //升级
                break;
            case R.id.ib_setting:
                //设置
                break;
        }
    }
}
