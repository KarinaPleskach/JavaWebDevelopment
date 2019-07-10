package by.training.domain_model.controller.comand.impl;

import by.training.domain_model.controller.comand.Command;
import by.training.domain_model.entity.Record;
import by.training.domain_model.exception.ServiceException;
import by.training.domain_model.service.DiskService;
import by.training.domain_model.service.fabric.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Find implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(String request) {
        LOGGER.info("task: " + request);

        DiskService service = ServiceFabric.getService();
        List<Record> recordList;
        String response = "empty";

        request = request.substring(4);
        try {
            recordList = service.find(request);
            response = recordList.toString();
        } catch (ServiceException e) {
            LOGGER.warn("warn from service");
        }
        return response;
    }
}
