package com.example.samuelraj.roompersistentexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TaskDAO {

    @Query("SELECT * FROM Task")
    List<Task> getAllTasks();

    @Insert
    void insertAllTasks(Task...tasks);

    @Delete
    void DeleteAllTasks(Task...tasks);

    @Update
    void UpdateAllTasks(Task...tasks);
}
