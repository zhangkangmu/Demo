package com.example.hong.frame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hong.frame.R;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * Created by 洪 on 2019/4/30.
 */

public class Frame extends SupportFragment{
    public static Frame newInstance() {
        Bundle args = new Bundle();
        Frame fragment = new Frame();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_main_fragment, container, false);
        return view;
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }
}
