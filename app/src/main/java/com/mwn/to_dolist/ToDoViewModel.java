package com.mwn.to_dolist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ToDoViewModel extends AndroidViewModel {
    private ToDoRepository toDoRepository;
    private LiveData<List<ToDo>> toDoList;
    public ToDoViewModel(@NonNull Application application) {
        super(application);
        toDoRepository=new ToDoRepository(application);
        toDoList=toDoRepository.show();
    }

    public void insert (ToDo toDo){
        toDoRepository.insertData(toDo);
    }
    public void delete (ToDo toDo){
        toDoRepository.deleteData(toDo);
    }
    public void update (ToDo toDo){
        toDoRepository.updateData(toDo);
    }

    public LiveData<List<ToDo>> show(){
        return toDoList;
    }

}
