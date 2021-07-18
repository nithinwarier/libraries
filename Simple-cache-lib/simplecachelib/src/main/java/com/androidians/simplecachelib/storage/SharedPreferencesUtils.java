package com.androidians.simplecachelib.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class SharedPreferencesUtils {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

    @SuppressLint("CommitPrefEdits")
    public SharedPreferencesUtils(Context context, String sharedPrefName) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
    }

    protected void putObject(String key, Object value) {
        if (value == null) {
            removeKey(key);
        } else {
            String str = gson.toJson(value);
            editor.putString(key, str);
            editor.apply();
        }
    }


    protected <T> T getObject(String key, Class<T> tClass, T defValue) {
        if (contains(key)) {
            String str = getString(key);
            if (str != null) {
                T t = gson.fromJson(str, tClass);
                return t;
            }
        }
        return defValue;
    }



    protected String getString(String key) {
        return getString(key, null);
    }

    protected String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    protected boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    protected void removeKey(String key) {
        editor.remove(key);
    }

}
