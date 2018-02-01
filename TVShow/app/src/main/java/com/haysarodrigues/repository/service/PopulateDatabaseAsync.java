package com.haysarodrigues.repository.service;

import android.os.AsyncTask;
import android.util.Log;

import com.haysarodrigues.database.AppDatabase;
import com.haysarodrigues.database.DatabaseInitializer;
import com.haysarodrigues.model.Movies;
import com.haysarodrigues.repository.api.APIClient;
import com.haysarodrigues.repository.api.WebServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Haysa on 31/01/18.
 */

public class PopulateDatabaseAsync {

    private final static String API_KEY = "782f2aaaee7308f5db36241b029cf5e9";
    private final String TAG = "PopulateDatabaseAsync";
    List<Movies.Movie> moviesFromService;



    public void populateAsync(final AppDatabase database) {
        new GetMoviesTask(database).execute();
    }


    private class GetMoviesTask extends AsyncTask<String, Void, List<Movies>> {

        List<Movies> moviesList;
        private final AppDatabase appDatabase;

        private GetMoviesTask(AppDatabase appDB) {
            appDatabase = appDB;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TAG, "Call onPreExecute from AsyncTask");

        }

        @Override
        protected List<Movies> doInBackground(String... strings) {

            Log.i(TAG, "GetMoviesTask.doInBackground");

            WebServices webServices = APIClient.getClient().create(WebServices.class);

            Call<Movies> call = webServices.getMovies(API_KEY);

            call.enqueue(new Callback<Movies>() {
                @Override
                public void onResponse(Call<Movies> call, Response<Movies> response) {
                    moviesFromService = response.body().getResults();

                    Log.i(TAG, "Call onResponse from Callback");

                    DatabaseInitializer databaseInitializer = new DatabaseInitializer();
                    for (Movies.Movie item : moviesFromService){
                        databaseInitializer.populateDatabaseWithMovies(appDatabase, item);

                    }

                }

                @Override
                public void onFailure(Call<Movies> call, Throwable t) {
                    Log.e("GetMoviesTask.onFailure", t.toString());
                }
            });


            return moviesList;
        }


        @Override
        protected void onPostExecute(List<Movies> movies) {
            super.onPostExecute(movies);
            Log.i(TAG, "GetMoviesTask.onPostExecute");

        }
    }
}
