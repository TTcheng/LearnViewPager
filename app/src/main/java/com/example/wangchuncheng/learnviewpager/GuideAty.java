package com.example.wangchuncheng.learnviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangChunCheng on 2017/10/14.
 */

public class GuideAty extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private static  final String TAG = "GuideAty";

    private ViewPager viewPager;
    private List<View> views;
    private ViewPagerAdapter viewPagerAdapter;
    private Button btnStartHome;

    private ImageView[] dots;
    private int[] ids = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        Log.d(TAG,"onCreate");
        initViews();
        initDots();
    }
    private void initViews(){
        System.out.println("initViews()");
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.view1,null));
        views.add(inflater.inflate(R.layout.view2,null));
        views.add(inflater.inflate(R.layout.view3,null));
        views.add(inflater.inflate(R.layout.view4,null));

        viewPagerAdapter = new ViewPagerAdapter(views,this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(this);

        btnStartHome = (Button)views.get(3).findViewById(R.id.btnStartHome);
        btnStartHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideAty.this,MainActivity.class));
                finish();
            }
        });

    }
    private void initDots(){
        System.out.println("initDots");
        dots = new ImageView[views.size()];
        for (int i= 0;i<views.size();i++){
            dots[i]= (ImageView) findViewById(ids[i]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i= 0;i<ids.length;i++) {
            if(position == i){
                dots[i].setImageResource(R.drawable.bullet_blue);
            }
            else dots[i].setImageResource(R.drawable.bullet_grey);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
