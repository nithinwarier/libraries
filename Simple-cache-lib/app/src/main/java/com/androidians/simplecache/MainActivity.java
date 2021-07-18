package com.androidians.simplecache;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.androidians.simplecachelib.core.SimpleCacheManager;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private SimpleCacheManager simpleCacheManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleCacheManager = SimpleCacheManager.getInstance(this);
        addValuesToCache();
        fetchValuesFromCache();
    }

    private void fetchValuesFromCache() {
        int value1 = (int) simpleCacheManager.fetch("test1");
        String value2 = (String) simpleCacheManager.fetch("test2");
        Log.e(TAG, "value1: "+value1);
        Log.e(TAG, "value2: "+value2);
    }

    private void addValuesToCache() {
        simpleCacheManager.store("test1", 1);
        simpleCacheManager.store("test2", "abc");
    }
}