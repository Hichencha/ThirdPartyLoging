package com.test.thirdpartyloging

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.test.thirdpartyloging.utils.Utils

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var mUmengBtn: Button? = null
    var mShareBtn: Button? = null
    var mPrimordialBtn: Button? = null
    var mBundle: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        mUmengBtn = findViewById(R.id.umeng_btn) as Button
        mShareBtn = findViewById(R.id.share_btn) as Button
        mPrimordialBtn = findViewById(R.id.primordial_btn) as Button

        mUmengBtn!!.setOnClickListener { v ->
            mBundle = Bundle()
            mBundle!!.putString("type", "umeng")
            Utils.startActivity(this, mBundle, ThirdPartyLoginActivity::class.java, false)
        }

        mShareBtn!!.setOnClickListener { v ->
            var intent = Intent(this, ThirdPartyLoginActivity::class.java)
            mBundle = Bundle()
            mBundle!!.putString("type", "Share")
            intent.putExtras(mBundle)
            startActivity(intent)
        }

        mPrimordialBtn!!.setOnClickListener { v ->
            mBundle = Bundle()
            mBundle!!.putString("type", "primordial")
            Utils.startActivity(this, mBundle, ThirdPartyLoginActivity::class.java, false)
        }
    }


    override fun onClick(v: View?) {

    }

}