package com.navigation.guidingapp.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by jiayong-xiao on 2017/2/11.
 */

public class BaseActivity extends AppCompatActivity {
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
