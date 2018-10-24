package com.test.thirdpartyloging;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * Created by chencha on 16/8/23.
 */

public class TestApplication extends Application {
    //开放平台注册的 appId  AppKey
    @Override
    public void onCreate() {
        super.onCreate();
    }

    {
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
}
