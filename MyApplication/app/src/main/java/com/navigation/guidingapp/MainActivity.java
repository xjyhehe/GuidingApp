package com.navigation.guidingapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.navigation.guidingapp.base.BaseActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String sha1 = sHA1();
        Log.i("hehe",sha1);
    }

    public String sHA1() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            String result = hexString.toString();
            return result.substring(0, result.length()-1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
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
