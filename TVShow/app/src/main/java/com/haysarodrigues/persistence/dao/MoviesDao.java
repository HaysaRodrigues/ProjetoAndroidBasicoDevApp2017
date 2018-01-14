package com.haysarodrigues.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.haysarodrigues.model.Movies;

import java.util.List;

/**
 * Created by Haysa on 13/01/18.
 */

@Dao
public interface MoviesDao {

    @Query("SELECT * FROM movie")
    List<Movies.Movie> getAll();


    @Insert
    void insertAll(Movies.Movie... movies);


}