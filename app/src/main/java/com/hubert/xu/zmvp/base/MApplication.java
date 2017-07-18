package com.hubert.xu.zmvp.base;

import android.app.Application;

import com.hubert.xu.zmvp.utils.SPUtil;
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

    private String spName = "HubertXu_SP_Data";
    private static MApplication mAppContext = null;

    public static MApplication getApplication() {
        return mAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
        initUtils();
        initComplie();
        initData();
    }

    private void initUtils() {
        Util.init(mAppContext);
        SPUtil.init(mAppContext, spName);
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
