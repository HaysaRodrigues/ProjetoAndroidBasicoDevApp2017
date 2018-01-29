package com.haysarodrigues.ui.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.haysarodrigues.database.AppDatabase;
import com.haysarodrigues.database.DatabaseInitializer;
import com.haysarodrigues.repository.api.APIClient;
import com.haysarodrigues.repository.api.WebServices;
import com.haysarodrigues.ui.adapter.MoviesAdapter;
import com.haysarodrigues.model.Movies;
import com.haysarodrigues.tvshow.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Haysa on 08/08/17.
 */

public class FragmentMovies extends android.support.v4.app.Fragment {

    private static final String TAG = "FragmentMovies";
    public static ListView listView;
    List<Movies.Movie> moviesFromService;
    List<Movies.Movie> moviesFromDB;
    private final static String API_KEY = "782f2aaaee7308f5db36241b029cf5e9";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        listView = view.findViewById(R.id.listViewMovies);

        GetMoviesTask getMoviesTask = new GetMoviesTask(AppDatabase.getAppDatabase(getContext()));
        getMoviesTask.execute();



        return view;
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

            Log.i(TAG, "Call doInBackground from AsyncTask");

            WebServices webServices = APIClient.getClient().create(WebServices.class);

            Call<Movies> call = webServices.getMovies(API_KEY);

            call.enqueue(new Callback<Movies>() {
                @Override
                public void onResponse(Call<Movies> call, Response<Movies> response) {
                    moviesFromService = response.body().getResults();
//                    listView.setAdapter(new MoviesAdapter(getContext(), moviesFromService));

                    Log.i(TAG, "Call onResponse from Callback");

                    DatabaseInitializer databaseInitializer = new DatabaseInitializer();
                    for (Movies.Movie item : moviesFromService){
                        databaseInitializer.populateDatabaseWithMovies(appDatabase, item);
//                        moviesFromService = appDatabase.moviesDao().getAll();
//                        moviesFromDB = moviesFromService.get(0);
//                        Log.i("--========--=->", moviesFromService.get(0).toString());


//
//                        //The user can be retrieved
//                        List<User> users = mDatabase.userDao().getUsers();
//                        assertThat(users.size(), is(1));
//                        User dbUser = users.get(0);
//                        assertEquals(dbUser.getId(), USER.getId());
                    }

                    moviesFromDB = appDatabase.moviesDao().getAll();
                    listView.setAdapter(new MoviesAdapter(getContext(), moviesFromDB));
                }

                @Override
                public void onFailure(Call<Movies> call, Throwable t) {
                    Log.e("CAIU ONFAILURE --->", t.toString());
                }
            });




            return moviesList;
        }


        @Override
        protected void onPostExecute(List<Movies> movies) {
            super.onPostExecute(movies);
            Log.i(TAG, "Call onPostExecute from AsyncTask");

        }
    }
}
