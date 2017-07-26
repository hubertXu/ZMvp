package com.hubert.xu.zmvp.module.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.utils.SPUtil;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        SPUtil.getInstance().put(Constants.IS_FIREST_START, true);
    }
}
