package com.example.hong.customize.cehua.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hong.customize.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 洪 on 2019/5/2.
 */

public class MainContent extends SupportFragment {

    public static MainContent newInstance() {
        
        Bundle args = new Bundle();
        
        MainContent fragment = new MainContent();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customize_cehuamianban_mian, container, false);
        return view;
    }
}
