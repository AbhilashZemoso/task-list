package com.codurance.training.tasksSolid.manager;

import com.codurance.training.tasksSolid.InputHandler;
import com.codurance.training.tasksSolid.commands.*;

import java.io.PrintWriter;

public class TaskExecutor implements Executor{

    private final Add addCommand;
    private final AddTask addTaskCommand;
    private final ShowTask showTaskCommand;
    private final UpdateTask updateTaskCommand;
    private final Help helpCommand;
    private final PrintWriter out;

    public TaskExecutor(PrintWriter out) {
        addTaskCommand = new AddTask(out);
        addCommand = new Add(addTaskCommand);
        showTaskCommand = new ShowTask(out);
        updateTaskCommand = new UpdateTask(out);
        helpCommand = new Help(out);
        this.out = out;
    }

    public void execute() {
        String command = InputHandler.getCommand();
        CommandEnum commandEnum = CommandEnum.getCommandEnum(command);
        switch (commandEnum) {
            case SHOW:
                showTaskCommand.printAllTaskDetails();
                break;
            case ADD:
                addCommand.processTask();
                break;
            case CHECK:
                updateTaskCommand.check();
                break;
            case UNCHECK:
                updateTaskCommand.uncheck();
                break;
            case HELP:
                helpCommand.printAvailableCommands();
                break;
            case INVALID:
                error(command);
                break;
            default:
                break;
        }
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
