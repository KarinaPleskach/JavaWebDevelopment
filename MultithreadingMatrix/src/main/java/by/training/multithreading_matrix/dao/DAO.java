package by.training.multithreading_matrix.dao;

public interface DAO<T> {
    /**
     * Resave list that are saved in DAO to list that is get in params.
     *
     * @param      beans to be resaved.
     * @throws     DAOException if beans are not exist or empty.
     * @since      1.0
     */
    void update(int[][] beans) throws DAOException;
    T get();
    boolean set(int row, int col, int value);
}
