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
        //微信 appid appsecret
        PlatformConfig.setWeixin("#####", "#####");
        //  新浪微博 appid appsecret
        PlatformConfig.setSinaWeibo("####", "####");
        //qq appid appsecret
        PlatformConfig.setQQZone("####", "#####");
    }
}
