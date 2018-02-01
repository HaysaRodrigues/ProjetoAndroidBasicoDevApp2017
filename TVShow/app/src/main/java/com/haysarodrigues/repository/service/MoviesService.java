package com.haysarodrigues.repository.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.haysarodrigues.database.AppDatabase;


/**
 * Created by Haysa on 30/01/18.
 */

public class MoviesService extends Service {

    private final IBinder mBinder = new MyBinder();
    private String TAG = "MoviesService";


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        PopulateDatabaseAsync populateDatabaseAsync = new PopulateDatabaseAsync();
        populateDatabaseAsync.populateAsync(AppDatabase.getAppDatabase(getApplicationContext()));
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        PopulateDatabaseAsync populateDatabaseAsync = new PopulateDatabaseAsync();
        populateDatabaseAsync.populateAsync(AppDatabase.getAppDatabase(getApplicationContext()));
        return mBinder;
    }

    public class MyBinder extends Binder {
        public MoviesService getService(){
            return MoviesService.this;
        }
    }



}
