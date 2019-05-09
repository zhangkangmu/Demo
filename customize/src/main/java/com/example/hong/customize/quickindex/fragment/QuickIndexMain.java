package com.example.hong.customize.quickindex.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hong.customize.R;
import com.example.hong.customize.R2;
import com.example.hong.customize.quickindex.adapter.MyAdapter;
import com.example.hong.customize.quickindex.other.Friend;
import com.example.hong.customize.quickindex.ui.QuickIndexBar;
import com.example.hong.customize.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;

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
    @BindView(R2.id.listview)
    ListView listview;

    private ArrayList<Friend> friends=new ArrayList<Friend>();
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
                Log.d("zyh", letter);
            }
        });
        //1.准备数据
        fillList();
        //2.对数据进行排序
        Collections.sort(friends);
        //3.设置Adapter
        listview.setAdapter(new MyAdapter(friends,getContext()));
        Utils.getPinyin("张宇洪");
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void fillList() {
        // 虚拟数据
        friends.add(new Friend("aa李伟"));
        friends.add(new Friend("张三"));
        friends.add(new Friend("阿三"));
        friends.add(new Friend("阿四"));
        friends.add(new Friend("段誉"));
        friends.add(new Friend("段正淳"));
        friends.add(new Friend("张三丰"));
        friends.add(new Friend("陈坤"));
        friends.add(new Friend("林俊杰1"));
        friends.add(new Friend("陈坤2"));
        friends.add(new Friend("王二a"));
        friends.add(new Friend("林俊杰a"));
        friends.add(new Friend("张四"));
        friends.add(new Friend("林俊杰"));
        friends.add(new Friend("王二"));
        friends.add(new Friend("王二b"));
        friends.add(new Friend("赵四"));
        friends.add(new Friend("杨坤"));
        friends.add(new Friend("赵子龙"));
        friends.add(new Friend("杨坤1"));
        friends.add(new Friend("李伟1"));
        friends.add(new Friend("宋江"));
        friends.add(new Friend("宋江1"));
        friends.add(new Friend("李伟3"));
    }
}
