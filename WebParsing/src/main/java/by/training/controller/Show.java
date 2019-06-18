package by.training.controller;

import by.training.entity.Voucher;
import by.training.service.Service;
import by.training.service.ServiceException;
import by.training.service.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class Show implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(String request) {
        LOGGER.info("Show task: " + request);

        Service<Voucher> service = ServiceFabric.getService();
        List<Voucher> vouchers;
        String response = "empty, please parse some xml file";
        try {
            vouchers = service.show();
            response = vouchers.toString();
        } catch (ServiceException e) {
            LOGGER.warn("unuseful result from service");
        }
        return response;
    }
}
