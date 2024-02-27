package com.mwn.to_dolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ToDoDAO {
    @Insert
    public void insert(ToDo toDo);
    @Update
    public void update(ToDo toDo);
    @Delete
    public void delete(ToDo toDo);
    @Query("SELECT * FROM todo_list")
    public LiveData<List<ToDo>> show();
}
