package com.haysarodrigues.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.haysarodrigues.model.Series;

import java.util.List;

/**
 * Created by Haysa on 08/01/18.
 */

@Dao
public interface SerieDao {

    @Query("SELECT * FROM series")
    List<Series.Serie> getAllSeries();

    @Insert
    void insertAllSeries(Series.Serie... series);

    @Delete
    void delete(Series.Serie serie);


}
