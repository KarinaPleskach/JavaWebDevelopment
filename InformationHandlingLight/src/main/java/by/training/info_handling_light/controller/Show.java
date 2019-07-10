package by.training.info_handling_light.controller;

import by.training.info_handling_light.bean.model.Text;
import by.training.info_handling_light.service.Service;
import by.training.info_handling_light.service.ServiceException;
import by.training.info_handling_light.service.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Show implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public String execute(String request) {
        LOGGER.info("Show task: " + request);
        Service<Text> service = ServiceFabric.getService();
        String response = "Illegal request, please, open some file";

        try {
            Text text = service.get();
            response = text.getAllValue();
        } catch (ServiceException e) {
            LOGGER.error("Uninitialized text in execute(String request");
        }

        return response;
    }
}
