package com.pochekuev.application;

import android.graphics.Color;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

public final class Variables {

    public static final String APP_PREFERENCES = "Preferences"; // SharedPreferences settings name
    public static final String FNPP_USER = "Fnpp"; // Teacher Fnpp settings name

    @ColorInt
    public static int getTransparentColor(@ColorInt int color, @Nullable Double percentage) {
        int alpha = Color.alpha(color);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        alpha *= (percentage != null) ? percentage : 0.10; // Set alpha 10% of initial value

        return Color.argb(alpha, red, green, blue);
    }
}
