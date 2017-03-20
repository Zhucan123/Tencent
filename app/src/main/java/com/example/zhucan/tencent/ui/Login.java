package com.example.zhucan.tencent.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zhucan.tencent.R;

/**
 * Created by zhucan on 2017/3/17.
 */

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button turn=(Button)findViewById(R.id.loginButton);
        turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Main.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
