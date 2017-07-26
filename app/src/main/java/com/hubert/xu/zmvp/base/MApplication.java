package com.hubert.xu.zmvp.base;

import android.app.Application;
import android.content.Context;

import com.hubert.xu.zmvp.utils.ToastUtil;
import com.hubert.xu.zmvp.utils.Util;
import com.hubert.xu.zmvp.utils.imageload.ImageLoaderManager;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;


/**
 * author: XQ
 * time  : 2017/3/6
 * desc  : MApplication
 */
public class MApplication extends Application {

    private static Context mAppContext = null;

    public static Context getApplication() {
        return mAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
        initUtils();
        initComplie();
        initData();
    }

    private void initUtils() {
        Util.init(getApplicationContext());
        ToastUtil.init(this);
    }


    private void initComplie() {
        // LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Logger
        Logger.addLogAdapter(new AndroidLogAdapter());
        ImageLoaderManager.getInstance().init(this);
    }


    private void initData() {
    }
}
