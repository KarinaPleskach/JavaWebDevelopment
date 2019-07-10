package by.training.domain_model.controller.comand.impl;

import by.training.domain_model.controller.comand.Command;
import by.training.domain_model.exception.ServiceException;
import by.training.domain_model.service.DiskService;
import by.training.domain_model.service.fabric.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Save implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final char paramDelimiter = ' ';

    public String execute(String request) throws InvalidPathException {
        LOGGER.info("task: " + request);

        String url;
        String response;
        url = request.substring(request.indexOf(paramDelimiter) + 1);
        url = url.substring(0, (url.indexOf(paramDelimiter) != -1) ? url.indexOf(paramDelimiter) : url.length());
        response = "Error during opening disk..";

        Path path;
        try {
            path = Paths.get(url);
        } catch (InvalidPathException ex) {
            LOGGER.error("Error during opening disk in execute(String request)");
            return response;
        }

        try {
            DiskService service = ServiceFabric.getService();
            service.save(url);
            response = "Saved";
        } catch (ServiceException e) {
            LOGGER.error("Error during opening disk in execute(String request)");
        }

        return response;
    }
}
