package com.example.hong.customize.quickindex.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hong.customize.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 洪 on 2019/5/8.
 */

public class QuickIndexMain extends SupportFragment{

    public static QuickIndexMain newInstance() {
        Bundle args = new Bundle();
        QuickIndexMain fragment = new QuickIndexMain();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.customize_quickindex,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
