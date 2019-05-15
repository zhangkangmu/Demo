package com.example.hong.customize.cehua.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hong.customize.R;
import com.example.hong.customize.R2;
import com.example.hong.customize.cehua.other.Constant;
import com.example.hong.customize.cehua.ui.MLinearLayout;
import com.example.hong.customize.cehua.ui.SlideDragLayout;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 洪 on 2019/5/2.
 */

public class CehuaMainContent extends SupportFragment {

    @BindView(R2.id.menu_listview)
    ListView menuListview;
    @BindView(R2.id.iv_head)
    ImageView ivHead;
    @BindView(R2.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R2.id.my_layout)
    MLinearLayout myLayout;
    @BindView(R2.id.slideMenu)
    SlideDragLayout slideMenu;
    Unbinder unbinder;
    @BindView(R2.id.main_listview)
    ListView mainListview;

    public static CehuaMainContent newInstance() {

        Bundle args = new Bundle();

        CehuaMainContent fragment = new CehuaMainContent();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customize_cehua, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menuListview.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, Constant.sCheeseStrings) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.WHITE);
                return textView;
            }
        });
        mainListview.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, Constant.NAMES){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view=super.getView(position, convertView, parent);
                view.setScaleX(0.5f);
                view.setScaleY(0.5f);
                //以属性动画放大,ViewPropertyAnimator是新导入的jar包
                ViewPropertyAnimator.animate(view).scaleX(1).setDuration(200).start();
                ViewPropertyAnimator.animate(view).scaleY(1).setDuration(200).start();
                return view;
            }
        });

        slideMenu.setOnDragChangeListen(new SlideDragLayout.OnDragChangeListen() {
            @Override
            public void onClose() {
                ViewPropertyAnimator.animate(ivHead).translationX(15).setInterpolator(new CycleInterpolator(4)).setDuration(200).start();
            }

            @Override
            public void onOpen() {
                menuListview.smoothScrollToPosition(new Random().nextInt(menuListview.getCount()));
            }

            @Override
            public void onDraging(float fraction ) {
                Log.d("zyh","onDraging：fraction："+fraction);
                ViewHelper.setAlpha(ivHead,1-fraction);
            }
        });
         myLayout.setSlideMenu(slideMenu);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
