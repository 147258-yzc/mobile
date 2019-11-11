package com.yzc.myfragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yzc.myfragment.R;

import butterknife.OnClick;


public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    @OnClick(R.id.im_back)
    void back(){
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
    }
}


