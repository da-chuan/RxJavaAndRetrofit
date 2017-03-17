package com.chuan.rxjavaandretrofit.view.activity.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.chuan.rxjavaandretrofit.R;
import com.chuan.rxjavaandretrofit.utils.ScreenUtil;

public abstract class BaseActivity extends AppCompatActivity {

    private FrameLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        content = (FrameLayout) findViewById(R.id.main_content);
        content.addView(setCurrentContentView());
        initToolbar(toolbar);
        ScreenUtil.setStatusBarColor(this);
    }





    private void initToolbar(Toolbar toolbar){
        toolbar.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView title = (TextView) toolbar.findViewById(R.id.title);
        View rightLayout = toolbar.findViewById(R.id.title_right_layout);
        ImageView tip = (ImageView) rightLayout.findViewById(R.id.title_right_tip);
        TextView tips = (TextView) rightLayout.findViewById(R.id.title_right_tips);

        if (setTitle(title)){
            setSupportActionBar(toolbar);
        }else {
            toolbar.setVisibility(View.GONE);
        }
        if (initRightIcon(tip, tips)){
            rightLayout.setVisibility(View.VISIBLE);
        }else {
            rightLayout.setVisibility(View.GONE);
        }
    }

    protected boolean initRightIcon(ImageView iv, TextView tv) {
        return false;
    }



    public abstract boolean setTitle(TextView title);
    public abstract View setCurrentContentView();
}
