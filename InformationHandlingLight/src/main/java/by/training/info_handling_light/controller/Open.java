package by.training.info_handling_light.controller;

import by.training.info_handling_light.bean.model.Text;
import by.training.info_handling_light.service.Service;
import by.training.info_handling_light.service.ServiceException;
import by.training.info_handling_light.service.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

class Open implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public String execute(String request) {
        LOGGER.info("Open task: " + request);

        String response = "Error during opening disk..";

        Path path;
        try {
            path = Paths.get(request);
        } catch (InvalidPathException ex) {
            LOGGER.error("Error during opening disk in execute(String request)");
            return response;
        }

        if (Files.exists(path) && Files.isRegularFile(path)) {
            try {
                Service<Text> service = ServiceFabric.getService();
                service.update(path);
                response = "Welcome!";
            } catch (ServiceException e) {
                LOGGER.error("Error during opening disk in execute(String request)");
            }
        } else {
            LOGGER.error("Error during opening disk in execute(String request)");
        }

        return response;
    }
}
