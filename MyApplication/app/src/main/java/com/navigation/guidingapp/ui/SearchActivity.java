package com.navigation.guidingapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.navigation.guidingapp.R;
import com.navigation.guidingapp.adapter.SearchTipsAdapter;
import com.navigation.guidingapp.base.BaseActivity;

import java.util.List;

import butterknife.BindView;

public class SearchActivity extends BaseActivity implements Inputtips.InputtipsListener {

    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_result)
    RecyclerView rvResult;

    /**
     * 当前城市
     */
    private String city;
    /**
     * 返回结果适配器
     */
    private SearchTipsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        city = getIntent().getStringExtra("city");
    }

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
        //初始化RecyclerView
        rvResult.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SearchTipsAdapter(this);
        rvResult.setAdapter(adapter);

    }

    @Override
    public void initListener() {
        //添加searchView监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                InputtipsQuery inputQuery = new InputtipsQuery(newText, city);
                inputQuery.setCityLimit(true);
                Inputtips inputTips = new Inputtips(SearchActivity.this, inputQuery);
                inputTips.setInputtipsListener(SearchActivity.this);
                inputTips.requestInputtipsAsyn();
                return false;
            }
        });
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

    /**
     * 地址提示信息回调
     * @param tipList  返回结果
     * @param rCode  结果码
     */
    @Override
    public void onGetInputtips(List<Tip> tipList, int rCode) {

        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            //返回结果
            adapter.refreshData(tipList);
        }
    }
}
