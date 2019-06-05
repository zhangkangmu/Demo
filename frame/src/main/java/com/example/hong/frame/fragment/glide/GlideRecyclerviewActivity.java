package com.example.hong.frame.fragment.glide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hong.frame.R;
import com.example.hong.frame.fragment.glide.adapter.GlideRecyclerviewAdapter;

public class GlideRecyclerviewActivity extends Activity {

    private RecyclerView mRvGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_recyclerview);
        mRvGlide = findViewById(R.id.rv_glide);
        initData();

    }

    private void initData() {
       // 初始化Recyclerview
        GlideRecyclerviewAdapter glideRecyclerviewAdapter = new GlideRecyclerviewAdapter(this);

        mRvGlide.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRvGlide.setAdapter(glideRecyclerviewAdapter);
    }
}
