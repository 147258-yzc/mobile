package com.yzc.myfragment;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    public static Context app;
    @Override
    public void onCreate() {
        super.onCreate();

        app=getApplicationContext();
    }

    public static Context getContext() {
        return app;
    }
}
