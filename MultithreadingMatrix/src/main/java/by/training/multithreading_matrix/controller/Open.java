package by.training.multithreading_matrix.controller;

import by.training.multithreading_matrix.entity.Matrix;
import by.training.multithreading_matrix.service.Service;
import by.training.multithreading_matrix.service.ServiceException;
import by.training.multithreading_matrix.service.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Open implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final char paramDelimiter = ' ';

    public String execute(String request) {
        LOGGER.info("Open task: " + request);

        String response = "Error during opening file..";
        request = request.trim();

        if (request.indexOf(paramDelimiter) != -1) {
            LOGGER.warn("Illegal request in execute(String request)");
            return response;
        }

        File matrix;
        if (request.indexOf('/') != -1 || request.indexOf('\\') != -1) {
            matrix = new File(request);
        } else {
            URL url = getClass().getClassLoader().getResource(request);
            try {
                matrix = Paths.get(url.toURI()).toFile();
            } catch (URISyntaxException e) {
                LOGGER.warn("Error during opening xml file in execute(String request)");
                return response;
            }
        }
        if (!matrix.exists()) {
            LOGGER.warn("Error during opening xml file in execute(String request)");
            return response;
        }

        Service<Matrix> service = ServiceFabric.getService();
        try {
            service.update(matrix);
            response = "Opened!";
        } catch (ServiceException e) {
            LOGGER.warn("Illegal file in execute(String request)");
        }

        return response;
    }
}
