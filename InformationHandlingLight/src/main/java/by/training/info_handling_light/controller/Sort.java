package by.training.info_handling_light.controller;

import by.training.info_handling_light.service.ServiceException;
import by.training.info_handling_light.sorting_service.SortingService;
import by.training.info_handling_light.sorting_service.SortingServiceException;
import by.training.info_handling_light.sorting_service.SortingServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Sort implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public String execute(String request) {
        LOGGER.info("Sort task: " + request);
        SortingService service = SortingServiceFabric.getService();
        String response = "Sorted";

        request = request.toLowerCase();
        if (!request.matches("sentences_count|word_length|words_count")) {
            response = "Illegal sorting type";
            LOGGER.warn(response);
        }

        try {
            service.makeSorted(request);
        } catch (ServiceException e) {
            response = "Illegal request, please, open some file";
            LOGGER.warn(response);
        } catch (SortingServiceException e) {
            response = "Illegal request, please, choice sentences_count|word_length|words_count";
            LOGGER.warn(response);
        }

        return response;
    }
}
