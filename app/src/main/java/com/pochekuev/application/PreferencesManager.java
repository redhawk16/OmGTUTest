package com.pochekuev.application;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    private static final String PREF_NAME = Variables.APP_PREFERENCES;

    private static PreferencesManager sInstance;
    private final SharedPreferences mPref;

    private PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized PreferencesManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }

        return sInstance;
    }

    public void setValue(String key, Object value) {
        if(value instanceof String){
            mPref.edit().putString(key, (String) value).apply();
        } else if(value instanceof Integer){
            mPref.edit().putInt(key, (Integer) value).apply();
        } else if(value instanceof Boolean){
            mPref.edit().putBoolean(key, (Boolean) value).apply();
        } else if(value instanceof Float){
            mPref.edit().putFloat(key, (Float) value).apply();
        } else if(value instanceof Long){
            mPref.edit().putLong(key, (Long) value).apply();
        } else {
            mPref.edit().putString(key, value.toString()).apply();
        }
    }

    public Object getValue(String key, Object defValue) {
        if(defValue instanceof String){
            return mPref.getString(key, (String) defValue);
        } else if(defValue instanceof Integer){
            return mPref.getInt(key, (Integer) defValue);
        } else if(defValue instanceof Boolean){
            return mPref.getBoolean(key, (Boolean) defValue);
        } else if(defValue instanceof Float){
            return  mPref.getFloat(key, (Float) defValue);
        } else if(defValue instanceof Long){
            return mPref.getLong(key, (Long) defValue);
        } else {
            return mPref.getString(key, "");
        }
    }

    public int getValue(String key) {
        return mPref.getInt(key, 0);
    }

    public boolean contains(String key) {
        return mPref.contains(key);
    }

    public void removeValue(String key) {
        mPref.edit()
                .remove(key)
                .apply();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }

}
