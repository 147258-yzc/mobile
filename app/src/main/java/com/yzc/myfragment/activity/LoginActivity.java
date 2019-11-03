package com.yzc.myfragment.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.yzc.myfragment.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_username) EditText et_username;
    @BindView(R.id.et_pwd)EditText et_pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.bt_login)
    void login(){


        new Thread(){
            @Override
            public void run() {
                super.run();
                //OkHttpClient build=new OkHttpClient.Builder().build();
                OkHttpClient httpClient=new OkHttpClient();
                Request request = new Request
                        .Builder()
                        .url("http://www.baidu.com")
                        .get()
                        .build();
        /*httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });*/
                try {
                    Response response=httpClient.newCall(request).execute();
                    Log.d("Response",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
