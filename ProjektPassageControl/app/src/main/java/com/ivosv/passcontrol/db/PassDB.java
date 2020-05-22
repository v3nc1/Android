package com.ivosv.passcontrol.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ivosv.passcontrol.model.PassEntry;


@Database(entities = {PassEntry.class}, version = 1, exportSchema = false)
public abstract class PassDB extends RoomDatabase {

    public abstract PassDAO passDAO();

    private static PassDB INSTANCE;

    public static PassDB getDB(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PassDB.class, "passDB").allowMainThreadQueries().build();
        }
        return INSTANCE;

    }
    public static void destroyInstance() {
        INSTANCE = null;
    }

}
