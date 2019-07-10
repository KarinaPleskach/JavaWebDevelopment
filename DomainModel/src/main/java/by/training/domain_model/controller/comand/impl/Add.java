package by.training.domain_model.controller.comand.impl;

import by.training.domain_model.controller.comand.Command;
import by.training.domain_model.entity.Record;
import by.training.domain_model.exception.ControllerException;
import by.training.domain_model.exception.ServiceException;
import by.training.domain_model.service.DiskService;
import by.training.domain_model.service.fabric.ServiceFabric;
import by.training.domain_model.validator.LinesValidator;
import by.training.domain_model.validator.LinesValidatorFabric;
import by.training.domain_model.validator.ValidatorProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Add implements Command {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final char paramDelimiter = ' ';

    @Override
    public String execute(String request) throws ControllerException {
        LOGGER.info("task: " + request);

        DiskService service = ServiceFabric.getService();
        List<Record> recordList;
        String response = "Error during creating record..";
        boolean isPath = true;

        String url;
        url = request.substring(request.indexOf(paramDelimiter) + 1).trim();

        Path path = null;
        try {
            path = Paths.get(url);
        } catch (InvalidPathException ex) {
            isPath = false;
        }

        if (isPath && Files.exists(path) && Files.isRegularFile(path)) {
            try {
                recordList = service.get(path);
            } catch (ServiceException e) {
                LOGGER.error("Error with opening file in execute(String request)");
                throw new ControllerException();
            }
        } else {
            try {
                List<String> lines = new ArrayList<>();
                lines.add(url);
                recordList = service.get(lines);
            } catch (ServiceException e) {
                LOGGER.error("Error with opening file in execute(String request)");
                throw new ControllerException();
            }
        }

        try {
            service.add(recordList);
            response = "Added";
        } catch (ServiceException e) {
            LOGGER.error("Error with creating record from Service in execute(String request)");
            response = "Error with creating record from Service in execute(String request)";
        }

        return response;
    }
}
