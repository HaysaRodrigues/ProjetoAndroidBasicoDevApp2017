package com.haysarodrigues.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.haysarodrigues.model.Series;
import com.haysarodrigues.repository.SeriesRepository;

/**
 * Created by Haysa on 12/12/17.
 */

public class SeriesViewModel extends ViewModel{


    private LiveData<Series> mSeries;
    private SeriesRepository seriesRepository = new SeriesRepository();

    public void initLiveDataFromSeries(){
        if (mSeries != null){
            return;
        }

        mSeries = seriesRepository.getLiveDataSeries();
    }

    public LiveData<Series> getSeries(){
        return this.mSeries;
    }

}
