package by.training.web_parsing.dao;

import java.util.List;

public interface DAO<T> {
    void add(T... beans) throws DAOException;
    void add(List<T> beans) throws DAOException;
    void update(List<T> beans) throws DAOException;
    void delete();
    void delete(T... beans) throws DAOException;
    void delete(List<T> beans) throws DAOException;
    List<T> get() throws DAOException;
}
