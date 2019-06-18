package by.training.dao;

import java.util.List;

/**
 * The {@code DAO} interface provides
 * for saved beans any type extends from {@link Object}
 * in list and make average operations with it:
 * add, update, delete and get.
 * For all the methods in this interface that
 * receive or return params, it is generally true
 * that if this params are empty, an {@link DAOException}
 * is thrown.
 *
 * @author  Karina Pleskach
 * @see     VoucherDAO
 * @version 1.0
 * @param   <T> bean type extends from {@link Object}
 */
public interface DAO<T> {
    /**
     * Add to saved list array of beans.
     *
     * @param      beans to be saved.
     * @throws     DAOException if beans are not exist.
     * @since      1.0
     */
    void add(T... beans) throws DAOException;

    /**
     * Add to saved list list of beans.
     *
     * @param      beans to be saved.
     * @throws     DAOException if beans are not exist or empty.
     * @since      1.0
     */
    void add(List<T> beans) throws DAOException;

    /**
     * Resave list that are saved in DAO to list that is get in params.
     *
     * @param      beans to be resaved.
     * @throws     DAOException if beans are not exist or empty.
     * @since      1.0
     */
    void update(List<T> beans) throws DAOException;

    /**
     * Delete all beans that are saved in dao list.
     *
     * @since      1.0
     */
    void delete();

    /**
     * Delete only beans that are saved in dao list now.
     *
     * @param      beans  array to be deleted.
     * @throws     DAOException if beans are not exist or empty.
     * @since      1.0
     */
    void delete(T... beans) throws DAOException;

    /**
     * Delete only beans that are saved in dao list now.
     *
     * @param      beans list to be deleted.
     * @throws     DAOException if beans are not exist or empty.
     * @since      1.0
     */
    void delete(List<T> beans) throws DAOException;

    /**
     * Return the list of beans that are saved in dao now.
     * No changes with dao.
     *
     * @return     list of beans.
     * @throws     DAOException if beans are not exist or empty.
     * @since      1.0
     */
    List<T> get() throws DAOException;
}
