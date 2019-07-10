package by.training.info_handling_light.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Exit implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public String execute(String request) {
        LOGGER.info("Exit task: " + request);
        String response = "Bye";
        return response;
    }
}
