package com.haysarodrigues.repository.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.haysarodrigues.dao.SerieDao;
import com.haysarodrigues.model.Series;

/**
 * Created by Haysa on 08/01/18.
 */

@Database(entities = {Series.Serie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract SerieDao serieDao();

    public static AppDatabase getAppDatabase(Context context) {

        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "tvshow-database")
                            .allowMainThreadQueries()
                            .build();
        }

        return INSTANCE;

    }


}
