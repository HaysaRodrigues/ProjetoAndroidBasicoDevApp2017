package com.haysarodrigues.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.haysarodrigues.model.Movies;
import com.haysarodrigues.persistence.dao.MoviesDao;
import com.haysarodrigues.ui.fragments.FragmentMovies;

/**
 * Created by Haysa on 13/01/18.
 */

@Database(entities = {Movies.Movie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract MoviesDao moviesDao();

    public static AppDatabase getAppDatabase(Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "tvshow-database")
                    .allowMainThreadQueries().build();
        }

        return INSTANCE;

    }

    public static void destroyInstance(){
        INSTANCE = null;
    }


}