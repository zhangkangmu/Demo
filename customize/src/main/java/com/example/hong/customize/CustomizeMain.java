package com.example.hong.customize;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hong.customize.cehua.fragment.CehuaMainContent;
import com.example.hong.customize.cehuadeleted.fragment.SwipeMain;
import com.example.hong.customize.headParallax.fragment.ParallaxMain;
import com.example.hong.customize.nianxingkongjian.fragment.GooMian;
import com.example.hong.customize.quickindex.fragment.QuickIndexMain;
import com.example.hong.customize.stellarmap.fragment.MapMian;
import com.example.hong.customize.stringsort.fragment.StringSortMian;
import com.example.hong.customize.youkutexiao.YouKu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 洪 on 2019/5/1.
 */

public class CustomizeMain extends SupportFragment implements View.OnClickListener {

    @BindView(R2.id.tv_qq_cehuamianban)
    TextView tvQqCehuamianban;
    @BindView(R2.id.tv_quick_index)
    TextView tvquickindex;

    Unbinder unbinder;
    @BindView(R2.id.tv_parallax)
    TextView tvParallax;
    @BindView(R2.id.tv_swipelayout)
    TextView tvSwipelayout;
    @BindView(R2.id.tv_gooview)
    TextView tvgooview;
    @BindView(R2.id.stellar_map)
    TextView stellarMap;
    @BindView(R2.id.string_sort)
    TextView stringSort;
    @BindView(R2.id.youku_texiao)
    TextView youku_texiao;

    public static CustomizeMain newInstance() {

        Bundle args = new Bundle();
        Log.d("zyh","CustomizeMain newInstance");
        CustomizeMain fragment = new CustomizeMain();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customize_mian_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        Log.d("zyh","CustomizeMain onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initOnClickListen();
    }

    private void initOnClickListen() {
        tvQqCehuamianban.setOnClickListener(this);
        tvquickindex.setOnClickListener(this);
        tvParallax.setOnClickListener(this);
        tvSwipelayout.setOnClickListener(this);
        tvgooview.setOnClickListener(this);
        stellarMap.setOnClickListener(this);
        stringSort.setOnClickListener(this);
        youku_texiao.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //此处不知道为什么点击不生效，i和a的值不一样
//    @OnClick(R2.id.tv_qq_cehuamianban)
//    public void onViewClicked() {
//        int i = getId();
//        float a=R.id.tv_qq_cehuamianban;
//        if (i == R.id.tv_qq_cehuamianban)Toast.makeText(getContext(),"0000000000",Toast.LENGTH_SHORT).show();
//        start(CehuaMainContent.newInstance());
//    }


    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_qq_cehuamianban) {
            start(CehuaMainContent.newInstance());
        } else if (i == R.id.tv_quick_index) {
            start(QuickIndexMain.newInstance());
        } else if (i == R.id.tv_parallax) {
            start(ParallaxMain.newInstance());
        } else if (i == R.id.tv_swipelayout) {
            start(SwipeMain.newInstance());
        } else if (i == R.id.tv_gooview) {
            start(GooMian.newInstance());
        } else if (i == R.id.stellar_map) {
            start(MapMian.newInstance());
        }else if (i == R.id.string_sort) {
            start(StringSortMian.newInstance());
        }else if (i == R.id.youku_texiao) {
            Intent intent = new Intent(getActivity(), YouKu.class);
            startActivity(new Intent(intent));
        }
    }
}
