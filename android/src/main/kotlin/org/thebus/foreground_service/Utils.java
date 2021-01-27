package org.thebus.foreground_service;


import android.content.Context;
import android.content.Intent;

import java.util.Arrays;
import java.util.List;

public class Utils {


    static Class getMainActivityClass(Context context) {
        String packageName = context.getPackageName();
        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        String className = launchIntent.getComponent().getClassName();
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}

