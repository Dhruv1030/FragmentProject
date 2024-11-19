package com.dhruv.myfragments;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter_000 extends RecyclerView.Adapter<TaskAdapter_000.ViewHolder> {

    private ArrayList<Task> taskList;

    public TaskAdapter_000(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskCheckBox.setText(task.getText());
        holder.taskCheckBox.setChecked(task.isCompleted());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public void removeTask(int position) {
        taskList.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox taskCheckBox;

        public ViewHolder(View itemView) {
            super(itemView);
            taskCheckBox = itemView.findViewById(R.id.taskCheckBox);
        }
    }
}