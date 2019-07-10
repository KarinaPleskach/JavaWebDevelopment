package by.training.info_handling_light.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class WrongRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public String execute(String request) {
        LOGGER.warn("Illegal request in execute(String request)");
        String response = "Illegal request";
        return response;
    }
}
