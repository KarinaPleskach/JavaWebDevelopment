package by.training.info_handling_light.service;

import by.training.info_handling_light.bean.composite.CompositeTextElement;

import java.nio.file.Path;

public interface Service<T extends CompositeTextElement> {
    void update(Path path) throws ServiceException;
    T get() throws ServiceException;
}
