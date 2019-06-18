package by.training.dao;

/**
 * The {@code DAOFabric} class can be used
 * only for getting instance of {@link DAO} interface.
 *
 * @author  Karina Pleskach
 * @see     VoucherDAO
 * @version 1.0
 */
public final class DAOFabric {

    /**
     * Field that has implementation of {@link DAO} interface.
     * Change this field if you create your own implementation.
     */
    private static DAO dao = new VoucherDAO();

    /**
     * You can not create object of this class.
     * To use it call static method {@link #getDAO()}.
     */
    private DAOFabric() {
    }

    /**
     * Use this method to get dao instance from another package.
     * @return  implementation of {@link DAO} interface.
     * @since   1.0
     */
    public static DAO getDAO() {
        return  dao;
    }
}
