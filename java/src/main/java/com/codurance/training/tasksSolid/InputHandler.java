package com.codurance.training.tasksSolid;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler {
    private final BufferedReader inputReader;
    private static String commandLine;
    private static String[] commandLineInputs;

    public InputHandler(BufferedReader inputReader) {
        this.inputReader = inputReader;
    }

    public static String getCommand() {
        return commandLineInputs[0];
    }

    public static String getArguments() {
        return commandLineInputs[1];
    }

    public String readNextLine() {
        try {
            commandLine = inputReader.readLine();
            commandLineInputs = commandLine.split(" ", 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return commandLine;
    }
}
