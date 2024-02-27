package com.mwn.to_dolist;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.mwn.to_dolist.databinding.TaskrvBinding;

public class RVAdapter extends ListAdapter<ToDo,RVAdapter.viewHolder> {
    public RVAdapter(){
        super(CALLBACK);
    }
    private static final DiffUtil.ItemCallback<ToDo> CALLBACK=new DiffUtil.ItemCallback<ToDo>() {
        @Override
        public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getDescription().equals(newItem.getDescription());
        }
    };
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.taskrv,parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        ToDo toDo = getItem(position);
        holder.binding.taskTitle.setText(toDo.getTitle());
        holder.binding.taskDescription.setText(toDo.getDescription());
    }

    public ToDo getTodo(int position){
        return getItem(position);
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        TaskrvBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding=TaskrvBinding.bind(itemView);
        }
    }
}
