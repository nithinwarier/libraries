package com.androidians.simplecachelib.core;

import android.content.Context;

import com.androidians.simplecachelib.storage.StorageManager;

public class SimpleCacheManager {

    private static SimpleCacheManager simpleCacheManager;
    private StorageManager storageManager;

    public SimpleCacheManager(Context context) {
        this(new StorageManager(context));
    }

    public SimpleCacheManager(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public static SimpleCacheManager getInstance(Context context) {
        if (simpleCacheManager == null) {
            simpleCacheManager = new SimpleCacheManager(context);
        }

        return simpleCacheManager;
    }

    public void store(String key, Object value) {
        storageManager.store(key, value);
    }

    public Object fetch(String key) {
        return storageManager.fetch(key);
    }

}
