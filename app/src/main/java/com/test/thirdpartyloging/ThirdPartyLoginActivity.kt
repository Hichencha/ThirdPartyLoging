package com.test.thirdpartyloging

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.bean.SHARE_MEDIA


class ThirdPartyLoginActivity : AppCompatActivity(), View.OnClickListener {

    var mToolbarTitleLeft: TextView? = null
    var mCenterTitleTxt: TextView? = null
    var mBundle: Bundle? = null
    var mType: String? = null

    //umeng
    var mivWechat: ImageView? = null
    var ivqq: ImageView? = null
    var ivWechatShare: ImageView? = null
    var ivWxcircleShare: ImageView? = null
    var ivqqShare: ImageView? = null
    var ivqqShareQzone: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_umeng_layout)
        mBundle = intent.extras
        if (mBundle != null) {
            mType = mBundle!!.getString("type")
        }
        mToolbarTitleLeft = findViewById(R.id.toolbar_title_left)
        mCenterTitleTxt = findViewById(R.id.center_title_txt)
        mToolbarTitleLeft!!.setOnClickListener(this)
        mivWechat = findViewById(R.id.iv_wechat)
        ivqq = findViewById(R.id.iv_qq)
        ivWechatShare = findViewById(R.id.iv_wechat_share)
        ivWxcircleShare = findViewById(R.id.iv_wxcircle_share)
        ivqqShare = findViewById(R.id.iv_qq_share)
        ivqqShareQzone = findViewById(R.id.iv_qq_share_qzone)

        if (!TextUtils.isEmpty(mType)) {
            if (mType!!.equals("umeng")) {
                mCenterTitleTxt!!.setText("友盟第三方登陆分享")

                //登陆
                mivWechat!!.setOnClickListener { v -> UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.WEIXIN, authListener)
                }

                ivqq!!.setOnClickListener { v ->   UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.QQ, authListener) }

                //分享
                ivWechatShare!!.setOnClickListener { v -> }
                ivWxcircleShare!!.setOnClickListener { v -> }
                ivqqShare!!.setOnClickListener { v -> }
                ivqqShareQzone!!.setOnClickListener { v -> }


            } else if (mType!!.equals("Share")) {
                mCenterTitleTxt!!.setText("Share第三方登陆分享")
            } else if (mType!!.equals("primordial")) {
                mCenterTitleTxt!!.setText("原生第三方登陆分享")
            }
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.toolbar_title_left -> finish()
        }
    }

    var authListener: UMAuthListener = object : UMAuthListener {
        override fun onStart(platform: SHARE_MEDIA) {
        }

        override fun onComplete(platform: SHARE_MEDIA, action: Int, data: Map<String, String>) {
            toast("成功了")
        }

        override fun onError(platform: SHARE_MEDIA, action: Int, t: Throwable) {
            toast("失败：" + t.message)
        }

        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
            toast("取消了")
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        UMShareAPI.get(this).release()
    }

    fun Activity.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}

