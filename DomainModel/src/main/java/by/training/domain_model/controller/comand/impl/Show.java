package by.training.domain_model.controller.comand.impl;

import by.training.domain_model.controller.comand.Command;
import by.training.domain_model.entity.Record;
import by.training.domain_model.exception.ControllerException;
import by.training.domain_model.exception.ServiceException;
import by.training.domain_model.service.DiskService;
import by.training.domain_model.service.fabric.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Show implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public String execute(String request) throws ControllerException {
        LOGGER.info("task: " + request);

        DiskService service = ServiceFabric.getService();
        List<Record> recordList;
        String response = "empty";
        try {
            recordList = service.show();
            response = recordList.toString();
        } catch (ServiceException e) {
            LOGGER.warn("unuseful result from service");
        }
        return response;
    }
}
