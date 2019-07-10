package by.training.domain_model.dao;

import by.training.domain_model.exception.DAOException;

import java.util.List;

public interface Repository<T> {
    void add(List<T> beans) throws DAOException;
    void update(List<T> beans) throws DAOException;
    void delete();
    void delete(List<T> beans) throws DAOException;
    List<T> find(Specification<T>... specifications) throws DAOException;
    List<T> find() throws DAOException;
}
