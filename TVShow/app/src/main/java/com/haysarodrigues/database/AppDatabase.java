package com.haysarodrigues.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.haysarodrigues.model.Movies;
import com.haysarodrigues.model.Series;
import com.haysarodrigues.persistence.dao.MoviesDao;
import com.haysarodrigues.persistence.dao.SeriesDao;

/**
 * Created by Haysa on 13/01/18.
 */

@Database(entities = {Movies.Movie.class, Series.Serie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract MoviesDao moviesDao();

    public abstract SeriesDao seriesDao();

    public static AppDatabase getAppDatabase(Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "tvshow-database")
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;

    }

    public static void destroyInstance(){
        INSTANCE = null;
    }


}