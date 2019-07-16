package by.training.multithreading_matrix.service;

import java.io.File;

public interface Service<T> {
    T show();
    void update(File file) throws ServiceException;
    void fill() throws ServiceException;
}
