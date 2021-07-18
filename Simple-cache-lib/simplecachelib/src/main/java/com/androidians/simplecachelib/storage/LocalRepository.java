package com.androidians.simplecachelib.storage;

import android.content.Context;

public class LocalRepository extends SimpleCacheSharedPreferences implements CacheConstants {

    public LocalRepository(Context context) {
        super(context, SHARED_PREFERENCE_NAME);
    }

    public void store(String key, Object object) {
        putObject(key, object);
    }

    public Object fetch(String key) {
        return getObject(key, Object.class, null);
    }

}
