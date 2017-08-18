package com.hubert.xu.zmvp.module.model;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/18
 * Desc  :
 */

public class OriginalManager {

    private static final OriginalManager ourInstance = new OriginalManager();

    static OriginalManager getInstance() {
        return ourInstance;
    }

    private OriginalManager() {
    }

    public void getOriginalList(){

    }
}
