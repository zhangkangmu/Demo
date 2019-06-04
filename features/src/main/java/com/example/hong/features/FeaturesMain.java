package com.example.hong.features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hong.features.advertisement.Advertisement;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 洪 on 2019/6/4.
 */

public class FeaturesMain extends SupportFragment implements View.OnClickListener{

    private View tv_advertisement;

    public static FeaturesMain newInstance() {
        Bundle args = new Bundle();
        FeaturesMain fragment = new FeaturesMain();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.features_mian_layout, container, false);
        tv_advertisement = view.findViewById(R.id.tv_advertisement);
        initListen();
        return view;
    }

    private void initListen() {
        tv_advertisement.setOnClickListener(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_advertisement) {
            start(Advertisement.newInstance());
        }
    }
}
