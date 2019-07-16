package by.training.web_parsing.service;

import by.training.web_parsing.service.parser.Parser;

import java.io.File;
import java.util.List;

public interface Service<T> {
    boolean checkXMLByXSD(File xml, File xsd);
    List<T> show() throws ServiceException;
    void update(File xml, Parser parser) throws ServiceException;
}
