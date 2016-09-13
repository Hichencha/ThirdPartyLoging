package com.test.thirdpartyloging;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Iterator;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.iv_wechat)
    ImageView mWechat;
    @Bind(R.id.iv_qq)
    ImageView mQQ;
    @Bind(R.id.iv_sina)
    ImageView mSina;

    private UMShareAPI mShareAPI = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //首先获取UMShareAPI
        mShareAPI = UMShareAPI.get(this);
    }

    @OnClick({R.id.iv_wechat, R.id.iv_qq, R.id.iv_sina})
    @Override
    public void onClick(View view) {
//        选取授权平台,并授权
        SHARE_MEDIA platform = null;
        switch (view.getId()) {
            case R.id.iv_wechat:
                platform = SHARE_MEDIA.WEIXIN;
                break;
            case R.id.iv_qq:
                platform = SHARE_MEDIA.QQ;
                break;
            case R.id.iv_sina:
                platform = SHARE_MEDIA.SINA;
                break;
        }
        // doOauth接口返回的授权信息
        mShareAPI.doOauthVerify(MainActivity.this, platform, umAuthListener);

    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data != null) {
                //调用getplatforminfo接口来去除返回值
                mShareAPI.getPlatformInfo(MainActivity.this, platform, umAuthMesListener);
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(MainActivity.this, "授权失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "授权取消", Toast.LENGTH_SHORT);
        }
    };

    private UMAuthListener umAuthMesListener = new UMAuthListener() {

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Toast.makeText(MainActivity.this, "授权成", Toast.LENGTH_SHORT);

            String m = share_media.toString();
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                 //再次遍历拿出你需要的参数
            }


        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }


}
