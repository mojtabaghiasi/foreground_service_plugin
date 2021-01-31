package org.thebus.foreground_service;


import android.content.Context;
import android.content.Intent;

import java.util.Objects;


public class Utils {


    static Class getMainActivityClass(Context context) {
        String packageName = context.getPackageName();
        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        assert launchIntent != null;
        String className = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            className = Objects.requireNonNull(launchIntent.getComponent()).getClassName();
        }else{
            className = launchIntent.getComponent().getClassName();
        }
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}

