/*
 * Copyright 2017 Vorlonsoft LLC
 *
 * Licensed under The MIT License (MIT)
 */

package com.vorlonsoft.android.rate;

import android.content.Context;
import android.content.Intent;

import static com.vorlonsoft.android.rate.UriHelper.getGooglePlay;
import static com.vorlonsoft.android.rate.UriHelper.getAmazonAppstore;
import static com.vorlonsoft.android.rate.UriHelper.getSamsungGalaxyApps;
import static com.vorlonsoft.android.rate.UriHelper.isPackageExists;

final class IntentHelper {

    private static final String GOOGLE_PLAY_PACKAGE_NAME = "com.android.vending";

    private IntentHelper() {
    }

    static Intent createIntentForGooglePlay(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent(Intent.ACTION_VIEW, getGooglePlay(packageName));
        if (isPackageExists(context, GOOGLE_PLAY_PACKAGE_NAME)) {
            intent.setPackage(GOOGLE_PLAY_PACKAGE_NAME);
        }
        return intent;
    }

    static Intent createIntentForAmazonAppstore(Context context) {
        String packageName = context.getPackageName();
        return new Intent(Intent.ACTION_VIEW, getAmazonAppstore(packageName));
    }

    static Intent createIntentForSamsungGalaxyApps(Context context) {
        String packageName = context.getPackageName();
        return new Intent(Intent.ACTION_VIEW, getSamsungGalaxyApps(packageName));
    }

}
