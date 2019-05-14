package com.example.hong.demo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hong.customize.CustomizeMain;
import com.example.hong.frame.fragment.Frame;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.bt_kuangjia)
    RadioButton btKuangjia;
    @BindView(R.id.bt_zidingyi)
    RadioButton btZidingyi;
    @BindView(R.id.bt_texiao)
    RadioButton btTexiao;
    @BindView(R.id.bt_yangshi)
    RadioButton btYangshi;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    private int position;
//    SupportFragment fragmenet[4] ={new Frame().in,new };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Fragmentation.builder()
//                .stackViewMode(Fragmentation.BUBBLE)
//                .debug(true)
//                .install();
//        Fragmentation.builder()
//                // 显示悬浮球 ; 其他Mode:SHAKE: 摇一摇唤出   NONE：隐藏
//                .stackViewMode(Fragmentation.BUBBLE)
//                .debug(BuildConfig.DEBUG)
//             .install();
//        radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListen());
    }

    @OnClick({R.id.bt_kuangjia, R.id.bt_zidingyi, R.id.bt_texiao, R.id.bt_yangshi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_kuangjia:
//                if (findFragment(Frame.class) == null) {
                    loadRootFragment(R.id.fl_content, Frame.newInstance());
//                }
                break;
            case R.id.bt_zidingyi:
//                if (findFragment(CustomizeMain.class) == null) {
                    loadRootFragment(R.id.fl_content, CustomizeMain.newInstance());
//                }
                break;
            case R.id.bt_texiao:
                break;
            case R.id.bt_yangshi:
                break;
        }
    }

}
