package com.haysarodrigues.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.haysarodrigues.model.Series;

import java.util.List;

/**
 * Created by Haysa on 02/02/18.
 */

@Dao
public interface SeriesDao {

    @Query("SELECT * FROM serie")
    List<Series.Serie> getAllSeries();

    @Insert
    void insertAllSeries(Series.Serie... series);

}
