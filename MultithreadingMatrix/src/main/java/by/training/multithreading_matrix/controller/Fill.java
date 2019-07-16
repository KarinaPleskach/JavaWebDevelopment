package by.training.multithreading_matrix.controller;

import by.training.multithreading_matrix.entity.Matrix;
import by.training.multithreading_matrix.service.Service;
import by.training.multithreading_matrix.service.ServiceException;
import by.training.multithreading_matrix.service.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fill implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public String execute(String request) {
        LOGGER.info("Fill task: " + request);
        Service<Matrix> service = ServiceFabric.getService();
        String response = "Error in thread";
        try {
            service.fill();
            response = "Filled";
        } catch (ServiceException e) {
            LOGGER.error("Error in thread");
        }
        return response;
    }
}