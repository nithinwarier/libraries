package com.androidians.simplecachelib.storage;

import android.content.Context;

public class StorageManager {

    private Context context;
    private StorageManagerController storageManagerController;

    public StorageManager(Context context) {
        this(context, new StorageManagerController(context));
    }

    public StorageManager(Context context, StorageManagerController storageManagerController) {
        this.context = context;
        this.storageManagerController = storageManagerController;
    }

    public void store(String key, Object value) {
        storageManagerController.store(key, value);
    }

    public Object fetch(String key) {
        return storageManagerController.fetch(key);
    }

}
