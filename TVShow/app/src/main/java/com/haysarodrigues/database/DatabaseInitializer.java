package com.haysarodrigues.database;

import android.util.Log;

import com.haysarodrigues.model.Movies;

import java.util.List;

/**
 * Created by Haysa on 13/01/18.
 */

public class DatabaseInitializer {


    private static Movies.Movie addMovies (final AppDatabase database, Movies.Movie movie){
        database.moviesDao().insertAllMovies(movie);
        return movie;
    }

    public static void populateDatabaseWithMovies(AppDatabase database, Movies.Movie movie){
        addMovies(database, movie);
        List<Movies.Movie> movieList = database.moviesDao().getAllMovies();
    }


}
