package com.navigation.guidingapp.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.navigation.guidingapp.R;
import com.navigation.guidingapp.base.BaseActivity;

import butterknife.BindView;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_search);

    }

    @Override
    public void initView() {
        //设置searchView默认打开
        searchView.onActionViewExpanded();
        //设置ToolBar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
