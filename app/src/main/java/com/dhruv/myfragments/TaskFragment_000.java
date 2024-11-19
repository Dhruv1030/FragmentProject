package com.dhruv.myfragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.widget.Toast;
import java.util.ArrayList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TaskFragment_000 extends Fragment {

    private RecyclerView taskRecyclerView;
    private EditText taskInputEt;
    private FloatingActionButton addTaskFab;
    private ArrayList<Task> taskList;
    private TaskAdapter_000 taskAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        // Initialize views
        taskRecyclerView = view.findViewById(R.id.taskRecyclerView);
        taskInputEt = view.findViewById(R.id.taskInputEt);
        addTaskFab = view.findViewById(R.id.addTaskFab);

        // Initialize task list and adapter
        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter_000(taskList);

        // Setup RecyclerView
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        taskRecyclerView.setAdapter(taskAdapter);

        // Add task button click listener
        addTaskFab.setOnClickListener(v -> {
            String taskText = taskInputEt.getText().toString().trim();
            if (!taskText.isEmpty()) {
                addTask(taskText);
                taskInputEt.setText("");
            }
        });

        return view;
    }

    private void addTask(String taskText) {
        Task task = new Task(taskText, false);
        taskList.add(0, task);
        taskAdapter.notifyItemInserted(0);
        Toast.makeText(getContext(), "Task added!", Toast.LENGTH_SHORT).show();
    }
}
