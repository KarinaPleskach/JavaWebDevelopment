package by.training.domain_model.controller.comand.impl;

import by.training.domain_model.controller.comand.Command;
import by.training.domain_model.entity.Record;
import by.training.domain_model.exception.ServiceException;
import by.training.domain_model.service.DiskService;
import by.training.domain_model.service.fabric.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Delete implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(String request) {
        LOGGER.info("task: " + request);

        DiskService service = ServiceFabric.getService();
        String response;

        request = request.substring(6);
        try {
            service.delete(request);
            response = "Deleted";
        } catch (ServiceException e) {
            LOGGER.warn("Warning with deleted from Service");
            response = "Warning with deleted from Service";
        }

        return response;
    }
}
