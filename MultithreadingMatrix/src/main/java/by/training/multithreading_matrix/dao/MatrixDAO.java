package by.training.multithreading_matrix.dao;

import by.training.multithreading_matrix.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixDAO implements DAO<Matrix> {
    private static final Logger LOGGER = LogManager.getLogger();
    private Matrix matrix = new Matrix();

    /**
     * Resave list that are saved in DAO to list that is get in params
     * @param      beans to be resaved.
     * @throws DAOException if beans are not exist or empty.
     * @since 1.0
     */
    @Override
    public void update(int[][] beans) throws DAOException {
        LOGGER.info("start update in DAO");
        isNull(beans, "update(Matrix beans)");
        matrix = new Matrix(beans);
    }

    /**
     * Check if param is null.
     * @param obj that is checked.
     * @param methodName string representation of method.
     * @throws DAOException if obj is null.
     * @since 1.0
     */
    private void isNull(final Object obj, final String methodName)
            throws DAOException {
        if (obj == null) {
            String message = "Null object in " + methodName;
            LOGGER.warn(message);
            throw new DAOException(message);
        }
    }

    public Matrix get() {
        LOGGER.info("start get in DAO");
        Matrix result = new Matrix(matrix.getMatrix().clone());
        return result;
    }

    @Override
    public boolean set(int row, int col, int value) {
        LOGGER.info("start set in DAO");
        if (matrix.getElement(row, col) == 0) {
            matrix.setElement(row, col, value);
            return true;
        } else  {
            LOGGER.info("element already set");
            return false;
        }
    }
}
