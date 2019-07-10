package by.training.info_handling_light.sorting_service;

import by.training.info_handling_light.service.ServiceException;

public interface SortingService {
    void makeSorted(String request) throws ServiceException, SortingServiceException;
}
