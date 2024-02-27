package com.mwn.to_dolist;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ToDoRepository {
    private ToDoDAO toDoDAO;
    private LiveData<List<ToDo>> todolist;

    public ToDoRepository(Application application){
        ToDoDatabase toDoDatabase = ToDoDatabase.getInstance(application);
        toDoDAO=toDoDatabase.toDoDAO();
        todolist=toDoDAO.show();
    }

    public void insertData(ToDo toDo){new InsertTask(toDoDAO).execute(toDo);}
    public void updateData(ToDo toDo){new UpdateTask(toDoDAO).execute(toDo);}
    public void deleteData(ToDo toDo){new DeleteTask(toDoDAO).execute(toDo);}
    public LiveData<List<ToDo>> show()
    {
        return todolist;
    }

    public static class InsertTask extends AsyncTask<ToDo,Void,Void>{
        private ToDoDAO toDoDAO;

        public InsertTask(ToDoDAO toDoDAO) {
            this.toDoDAO = toDoDAO;
        }

        @Override
        protected Void doInBackground(ToDo... toDos) {
            toDoDAO.insert(toDos[0]);
            return null;
        }
    }
    public static class UpdateTask extends AsyncTask<ToDo,Void,Void>{
        private ToDoDAO toDoDAO;

        public UpdateTask(ToDoDAO toDoDAO) {
            this.toDoDAO = toDoDAO;
        }

        @Override
        protected Void doInBackground(ToDo... toDos) {
            toDoDAO.update(toDos[0]);
            return null;
        }
    }
    public static class DeleteTask extends AsyncTask<ToDo,Void,Void>{
        private ToDoDAO toDoDAO;

        public DeleteTask(ToDoDAO toDoDAO) {
            this.toDoDAO = toDoDAO;
        }

        @Override
        protected Void doInBackground(ToDo... toDos) {
            toDoDAO.delete(toDos[0]);
            return null;
        }
    }

}
