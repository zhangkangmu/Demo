package com.example.hong.customize.quickindex.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hong.customize.R;
import com.example.hong.customize.R2;
import com.example.hong.customize.quickindex.ui.QuickIndexBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 洪 on 2019/5/8.
 */

public class QuickIndexMain extends SupportFragment {

    @BindView(R2.id.quickIndexBar)
    QuickIndexBar quickIndexBar;
    Unbinder unbinder;

    public static QuickIndexMain newInstance() {
        Bundle args = new Bundle();
        QuickIndexMain fragment = new QuickIndexMain();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customize_quickindex, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quickIndexBar.setOnTouchListener(new QuickIndexBar.OnTouchListener() {
            @Override
            public void onTouchLetter(String letter) {
                Log.d("zyh",letter);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
