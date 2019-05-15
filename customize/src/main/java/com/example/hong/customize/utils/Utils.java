package com.example.hong.customize.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Toast;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by 洪 on 2019/5/9.
 * 张宇洪自己封装的一写工具类
 */

public class Utils {
    /**
     * 获取文本的高度
     * @param text
     * @return
     */
    public static float getTextHeight(String text, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(text,0,text.length(),rect);
        return rect.height();
    }

    /**
     * 获取汉字的拼音的方法
     * 会消耗一定的资源，所以不应该被频繁调用
     *需要引入pinyin4j.jar包
     * @param chinese
     * @return
     */
    public static String getPinyin(String chinese) {
        if(TextUtils.isEmpty(chinese)) return null;
        //用来设置转化的拼音的大小写，或者声调
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);   //设置转化的拼音是大写字母
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   //设置转化的拼音不带声调

        //1.由于只能对单个汉字转化，所以需要将字符串转化为字符数组，然后对每个字符转化，最后拼接起来
        char[] charArray = chinese.toCharArray();
        String pinyiu="";
        for(int i=0;i<charArray.length;i++){
            //2.过滤空格   张    宇   洪 ->ZHANGYUHONG
            if (Character.isWhitespace(charArray[i])) continue;
            //3.需要判断是否是汉字   a@#张&*&宇%#洪
            //汉字占2个字节，一个字节范围是-128~127，那么汉字肯定大于127
            if(charArray[i]>127){     //charArray[i]也可以是字节！！！！！！！！！！！！！！！
                //由于多音字的存在，比如单  dan shan，这个是不可避免的
                try {
                    String[] pinyinArr = PinyinHelper.toHanyuPinyinStringArray(charArray[i], hanyuPinyinOutputFormat);//拼音有音调之类的，因此要设置一个格式
                    if (pinyinArr!=null){
                        pinyiu+=pinyinArr[0];   //此处即使有多音字，那么也只能取第一个拼音
                    }else {
                        //说明没有找到对应的拼音，汉字有问题，或者可能不是汉字，则忽略
                    }
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                    //说明转化失败，不是汉字，比如O(∩_∩)O~，那么则忽略
                }
            }else {
                //肯定不是汉字，应该是键盘上能够直接输入的字符，这些字符能够排序，但不能获取拼音
                //所以可以直接拼接  a张宇洪->
                pinyiu += (charArray[i]+"").toUpperCase();
            }
        }
        return pinyiu;
    }


    public static Toast mToast;

    public static void showToast(Context mContext, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * dip 转换成 px
     * @param dip
     * @param context
     * @return
     */
    public static float dip2Dimension(float dip, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics);
    }
    /**
     * @param dip
     * @param context
     * @param complexUnit {@link TypedValue#COMPLEX_UNIT_DIP} {@link TypedValue#COMPLEX_UNIT_SP}}
     * @return
     */
    public static float toDimension(float dip, Context context, int complexUnit) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(complexUnit, dip, displayMetrics);
    }

    //获取状态栏的高度
    public static float getStatusBarHeight(Resources resources){
        int status_bar_height_id = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimension(status_bar_height_id);
    }

}
