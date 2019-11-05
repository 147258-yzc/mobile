package com.yzc.myfragment.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;
import com.yzc.myfragment.R;
import com.yzc.myfragment.bean.LoginResponse;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
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

        final String username=et_username.getText().toString();
        final String pwd=et_pwd.getText().toString();

        String url="10.10.16.65:8089/MobileShop/member/login2";


        /*new Thread(){
            @Override
            public void run() {
                super.run();*/
        OkHttpClient httpClient=new OkHttpClient.Builder().build();
        FormBody body=new FormBody.Builder()
                .add("input",username)
                .add("password",pwd)
                .build();
        Request request = new Request.Builder().url(url).post(body).build();
               /* OkHttpClient httpClient=new OkHttpClient();
                Request request = new Request
                        .Builder()
                        .url("10.10.16.65:8089/MobileShop/")
                        .get()
                        .build();*/

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String json=response.body().string();
                Gson gson=new Gson();
                LoginResponse loginResponse = gson.fromJson(json, LoginResponse.class);


            }
        });
               /* try {
                    Response response=httpClient.newCall(request).execute();
                    Log.d("Response",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();*/
    }
}
