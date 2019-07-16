package by.training.multithreading_matrix.controller;

import by.training.multithreading_matrix.entity.Matrix;
import by.training.multithreading_matrix.service.Service;
import by.training.multithreading_matrix.service.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Show implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    public String execute(String request) {
        LOGGER.info("Show task: " + request);

        Service<Matrix> service = ServiceFabric.getService();
        Matrix matrix = service.show();

        return matrix.toString();
    }
}
