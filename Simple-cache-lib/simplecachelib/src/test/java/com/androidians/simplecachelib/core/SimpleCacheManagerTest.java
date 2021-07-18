package com.androidians.simplecachelib.core;

import android.content.Context;
import android.content.SharedPreferences;

import com.androidians.simplecachelib.storage.LocalRepository;
import com.androidians.simplecachelib.storage.SharedPreferencesUtils;
import com.androidians.simplecachelib.storage.StorageManager;
import com.androidians.simplecachelib.storage.StorageManagerController;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SimpleCacheManagerTest {

    private static final String KEY = "key";
    private static final String KEY2 = "key2";
    private static final String VALUE = "value";
    private static final String VALUE2 = "value2";

    private SimpleCacheManager SUT;
    @Mock private Context context;
    @Mock private StorageManager storageManager;
    @Mock private SharedPreferences sharedPreferences;


    @Before
    public void setUp() throws Exception {
        storageManager = new StorageManager(context);
        SUT = new SimpleCacheManager(storageManager);
    }

    @Test
    public void store_success() {
        SUT.store(KEY, VALUE);
        assertEquals(VALUE, SUT.fetch(KEY));
    }

    @Test
    public void store_failure() {
        SUT.store(null, null);
        assertNull(null, null);
    }
}