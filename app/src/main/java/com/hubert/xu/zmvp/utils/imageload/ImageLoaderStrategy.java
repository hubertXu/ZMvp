package com.hubert.xu.zmvp.utils.imageload;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * author: XQ
 * time  : 2017/7/16
 * desc  :
 */

public interface ImageLoaderStrategy {

    void showImage(@NonNull ImageLoaderOptions options);

    void cleanMemory(Context context);

    // 在application的oncreate中初始化
    void init(Context context);
}
