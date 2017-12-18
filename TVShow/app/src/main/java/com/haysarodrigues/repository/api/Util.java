package com.haysarodrigues.repository.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.haysarodrigues.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haysa on 20/08/17.
 */

public class Util {

    private static final String TAG = "UtilParserClass";

    public static boolean checkIsConnect(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()){

            return true;

        } else{

            Toast.makeText(context, "No connection.", Toast.LENGTH_LONG).show();

        }

        return false;
    }


    public static InputStream getStream(String pUrl){

        try {

            URL url = new URL(pUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(1000);
            connection.setConnectTimeout(1000);
            connection.setDoInput(true);
            connection.connect();

                if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                    return connection.getInputStream();
                }


        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e(TAG, "Method getStream has catch MalformedURLException");

        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Method getStream has catch IOException");

        }

        return null;
    }



    public static String convertStreamToString(InputStream stream){

        String retorno = "";

        if (stream != null){

            byte[] bytes = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int read = 0;

            try {
                while ((read = stream.read(bytes)) > 0){
                    byteArrayOutputStream.write(bytes, 0, read);
                }

                byteArrayOutputStream.close();
                retorno = new String(byteArrayOutputStream.toByteArray());

            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, "Method convertStreamToString has catch IOException");
            }

        }

        return retorno;
    }


    public static List<Movie> parseJson(String body){

        List<Movie> movieList = new ArrayList<>();

        try {

            JSONObject jsonObject = new JSONObject(body);
            JSONArray jsonArray = jsonObject.getJSONArray("results");


            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);

                Movie movie = new Movie(
                        object.getString("title"),
                        object.getString("overview"),
                        object.getString("vote_average"),
                        object.getString("poster_path"));

                movieList.add(movie);
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "Method parseJson has catch JSONException");
        }


        return movieList;
    }
}