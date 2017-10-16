package com.example.wangchuncheng.learnviewpager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by WangChunCheng on 2017/10/14.
 */

public class WelcomeAty extends AppCompatActivity {

    private static  final String TAG = "WelcomeAty";
    private boolean isFirstIn = false;
    private static final int TIME = 2000;
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_GUIDE:
                    goGuide();
                    break;
                case GO_HOME:
                    goHome();
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Log.d(TAG,"onCreate");
        init();
    }

    private void goGuide() {
        Log.d(TAG,"start goGuide");
        Log.v(TAG,"为什么进不来 怎么这么难");

        startActivity(new Intent(WelcomeAty.this,GuideAty.class));
        finish();
        Log.d(TAG,"goGuide");
    }
    private void goHome() {
        startActivity(new Intent(WelcomeAty.this,MainActivity.class));
        finish();
    }
    private void init(){
        SharedPreferences sharedPreferences = getSharedPreferences("wang",MODE_PRIVATE);
        isFirstIn = sharedPreferences.getBoolean("isFirstIn",true);
        if(isFirstIn){
            handler.sendEmptyMessageDelayed(GO_GUIDE,TIME);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();
        }
        else handler.sendEmptyMessageDelayed(GO_HOME,TIME);
    }

}
