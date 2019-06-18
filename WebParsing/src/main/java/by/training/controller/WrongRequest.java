package by.training.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class WrongRequest implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(String request) {
        LOGGER.warn("Illegal request in execute(String request)");
        String response = "Illegal request:\n" +
                "Write parse method name and file path to update initial vouchers\n" +
                "show to see the vouchers\n" +
                "exit to end";
        return response;
    }
}
