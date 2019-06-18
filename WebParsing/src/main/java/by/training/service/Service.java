package by.training.service;

import by.training.service.parser.Parser;

import java.io.File;
import java.util.List;

public interface Service<T> {
    boolean checkXMLByXSD(File xml, File xsd);
    List<T> show() throws ServiceException;
    void update(File xml, Parser parser) throws ServiceException;
}
