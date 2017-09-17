package com.example.zhanggang.zhanggangtuwen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);

        text = "大家好，在下张刚。家是山西太原的，15年5月来的八维，到八维学习也两年多了，这两年多以来的收获，除了最主要的学习以外，我也结交了很多志同道合的朋友。";
        SpannableString span = new SpannableString(text);
        //文字颜色
        span.setSpan(new ForegroundColorSpan(Color.RED), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //超链接
        span.setSpan(new URLSpan("tel:1101230"),6,8,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //删除线
        span.setSpan(new StrikethroughSpan(),17,22,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //下划线
        span.setSpan(new UnderlineSpan(),27,37,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //下划线  第二种
        span.setSpan(new UnderlineSpan(),text.indexOf("学习以外"),text.indexOf("学习以外")+"学习之外".length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        Bitmap bitmap1 = BitmapFactory.decodeFile("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505663414010&di=80440db8ba710cc04e3cc66135b110e7&imgtype=0&src=http%3A%2F%2Fup.qqya.com%2Fallimg%2F201710-t%2F17-101802_79867.jpg");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setBounds(0,0,bitmapDrawable.getIntrinsicWidth(),bitmapDrawable.getIntrinsicHeight());
        span.setSpan(new ImageSpan(bitmapDrawable),text.indexOf("志同道合"),text.indexOf("志同道合")+"志同道合".length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(span);
    }
}
