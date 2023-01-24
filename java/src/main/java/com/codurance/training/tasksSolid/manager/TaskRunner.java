package com.codurance.training.tasksSolid.manager;

import com.codurance.training.tasksSolid.InputHandler;

import java.io.BufferedReader;
import java.io.PrintWriter;

import static com.codurance.training.tasksSolid.commands.CommandEnum.QUIT;

public final class TaskRunner implements Runnable {

    private final InputHandler inputHandler;
    private final PrintWriter out;
    private final Executor taskExecutor;

    public TaskRunner(BufferedReader reader, PrintWriter writer) {
        this.inputHandler = new InputHandler(reader);
        this.out = writer;
        taskExecutor = new TaskExecutor(out);
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String commandLine = inputHandler.readNextLine();
            if (commandLine.equalsIgnoreCase(QUIT.toString())) {
                break;
            }
            taskExecutor.execute();
        }
    }
}
