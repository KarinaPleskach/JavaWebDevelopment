package by.training.multithreading_matrix.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class MatrixController implements Controller {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final CommandProvider provider = new CommandProvider();
    private static final char paramDelimiter = ' ';

    public String giveResponse(String request) {
        String commandName;
        Command executionCommand;
        commandName = request.trim().substring(0, (request.indexOf(paramDelimiter) != -1) ? request.indexOf(paramDelimiter) : request.length());
        request = request.replace(commandName, "").trim();
        executionCommand = provider.getCommand(commandName);
        String response = "empty";
        response = executionCommand.execute(request);
        return response;
    }
}
