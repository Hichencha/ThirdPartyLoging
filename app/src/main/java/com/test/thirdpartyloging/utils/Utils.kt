package com.test.thirdpartyloging.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle


object Utils {

    fun startActivity(context: Context, bundle: Bundle?, activityClass: Class<*>?, closePreActivity: Boolean) {

        if (activityClass == null) {
            return
        }
        val intent = Intent(context, activityClass)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        context.startActivity(intent)
        if (closePreActivity) {
            (context as Activity).finish()
        }

    }
}
