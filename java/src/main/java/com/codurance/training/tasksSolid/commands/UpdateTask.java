package com.codurance.training.tasksSolid.commands;

import com.codurance.training.tasksSolid.InputHandler;
import com.codurance.training.tasksSolid.manager.Task;
import com.codurance.training.tasksSolid.manager.TaskContainer;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class UpdateTask {

    private final PrintWriter out;

    public UpdateTask(PrintWriter out) {
        this.out = out;
    }

    public void check() {
        setDone(InputHandler.getArguments(), true);
    }

    public void uncheck() {
        setDone(InputHandler.getArguments(), false);
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : TaskContainer.getTasks().entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
