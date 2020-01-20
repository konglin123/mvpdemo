package com.example.a12902.mvpdemo.app;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by ${shdf} on 17/4/11.
 * wechat：zcm656025633
 * exp：
 **/

public class AppApplication extends Application {
    static Context mAppApplication ;


    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = getApplicationContext();

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
               // .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("MVP")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

    }
    public static Context getContext() {
        return mAppApplication;
    }

}
