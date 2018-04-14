package com.example.samuelraj.roompersistentexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by samuelraj on 15/04/18.
 */

@Database(entities = {Task.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDAO taskDAO();
}
