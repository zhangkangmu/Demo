package com.example.hong.customize;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hong.customize.cehua.fragment.CehuaMainContent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 洪 on 2019/5/1.
 */

public class CustomizeMain extends SupportFragment {

    @BindView(R2.id.tv_qq_cehuamianban)
    TextView tvQqCehuamianban;
    Unbinder unbinder;

    public static CustomizeMain newInstance() {

        Bundle args = new Bundle();

        CustomizeMain fragment = new CustomizeMain();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customize_mian_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R2.id.tv_qq_cehuamianban)
    public void onViewClicked() {
        int i = getId();
        if (i == R.id.tv_qq_cehuamianban)Toast.makeText(getContext(),"0000000000",Toast.LENGTH_SHORT).show();
        start(CehuaMainContent.newInstance());
    }


    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }
}
