package com.navigation.guidingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.navigation.guidingapp.base.BaseActivity;

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
                Intent videoIntent = new Intent(this,VideoActivity.class);
                startActivity(videoIntent);
                break;
            case R.id.ib_navigate:
                Intent navigateIntent = new Intent(this,MapActivity.class);
                startActivity(navigateIntent);
                //导航
                break;
            case R.id.ib_update:
                //升级
                Intent updateIntent = new Intent(this,UpdateActivity.class);
                startActivity(updateIntent);
                break;
            case R.id.ib_setting:
                //设置
                Intent settingIntent = new Intent(this,SettingActivity.class);
                startActivity(settingIntent);
                break;
        }

    }
}
