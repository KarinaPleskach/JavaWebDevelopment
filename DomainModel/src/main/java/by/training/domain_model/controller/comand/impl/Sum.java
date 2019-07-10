package by.training.domain_model.controller.comand.impl;

import by.training.domain_model.controller.comand.Command;
import by.training.domain_model.entity.Record;
import by.training.domain_model.entity.music.Duration;
import by.training.domain_model.exception.ServiceException;
import by.training.domain_model.service.DiskService;
import by.training.domain_model.service.fabric.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sum implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(String request) {
        LOGGER.info("task: " + request);

        DiskService service = ServiceFabric.getService();
        Duration duration;

        request = request.substring(3);

        try {
            duration = service.sum(request);
        } catch (ServiceException e) {
            LOGGER.warn("unuseful result from service");
            return "Can not find records";
        }

        return duration.toString();
    }
}

