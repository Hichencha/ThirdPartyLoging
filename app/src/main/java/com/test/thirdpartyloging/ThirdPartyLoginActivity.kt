package com.test.thirdpartyloging

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class ThirdPartyLoginActivity : AppCompatActivity(), View.OnClickListener {

    var mToolbarTitleLeft: TextView? = null
    var mCenterTitleTxt: TextView? = null
    var mBundle: Bundle? = null
    var mType: String? = null


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

        if (!TextUtils.isEmpty(mType)) {
            if (mType!!.equals("umeng")) {
                mCenterTitleTxt!!.setText("友盟第三方登陆分享")
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

}

