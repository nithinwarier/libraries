package com.androidians.simplecachelib.storage;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StorageManagerController {

    private final Map<String, Object> map;
    private final LocalRepository localRepository;

    public StorageManagerController(Context context) {
        map = new LinkedHashMap<>(CacheConstants.CACHE_SIZE);
        localRepository = new LocalRepository(context);
    }

    public void store(String key, Object value) {
        map.put(key, value);
        localRepository.store(key, value);
    }

    public Object fetch(String key) {
        if (!map.containsKey(key)) {
            Object value = localRepository.getObject(key, Object.class, null);
            map.put(key, value);
        }

        return map.get(key);
    }

}
