package com.haysarodrigues.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.haysarodrigues.database.AppDatabase;
import com.haysarodrigues.model.Series;

/**
 * Created by Haysa on 12/12/17.
 */

public class SeriesViewModel extends AndroidViewModel{

    private final LiveData<Series.Serie> mSeries;


    public SeriesViewModel (@NonNull Application application){
        super(application);

        mSeries = (LiveData<Series.Serie>) AppDatabase.
                getAppDatabase(getApplication())
                .seriesDao()
                .getAllSeries();

    }

    public LiveData<Series.Serie> getSeriesLive(){
        return mSeries;
    }















//    private LiveData<Series> mSeries;
//    private SeriesLiveDataRepository seriesLiveDataRepository = new SeriesLiveDataRepository();
//
//    public void initLiveDataFromSeries(){
//        if (mSeries != null){
//            return;
//        }
//
//        mSeries = seriesLiveDataRepository.getLiveDataSeries();
//    }
//
//    public LiveData<Series> getSeries(){
//        return this.mSeries;
//    }

}
