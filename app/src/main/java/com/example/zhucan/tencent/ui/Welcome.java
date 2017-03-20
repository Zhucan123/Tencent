package com.example.zhucan.tencent.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.zhucan.tencent.R;


/**
 * Created by zhucan on 2017/3/17.
 */

public class Welcome extends Activity {

    class myRun implements Runnable{
        @Override
        public void run(){
            Intent intent=new Intent(Welcome.this,Login.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Handler handler=new Handler();
        handler.postDelayed(new myRun(),2500);

    }
}
