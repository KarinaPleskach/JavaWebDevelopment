package by.training.dao;

import by.training.entity.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code VoucherDAO} class is an implementation of
 * the {@code DAO} interface that provides
 * for saved beans any type extends from {@link Object}
 * in list and make average operations with it:
 * add, update, delete and get.
 * For all the methods in this interface that
 * receive or return params, it is generally true
 * that if this params are empty, an {@link DAOException}
 * is thrown.
 *
 * @author  Karina Pleskach
 * @see     DAO
 * @version 1.0
 */
class VoucherDAO implements DAO<Voucher> {

    /**
     * Field that use to logging this class.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Field that saved list of beans.
     */
    private List<Voucher> vouchers = new ArrayList<>();


    /**
     * Add to saved list array of beans.
     * @param      beans to be saved.
     * @throws DAOException if beans are not exist or empty.
     * @since 1.0
     */
    @Override
    public void add(final Voucher... beans) throws DAOException {
        LOGGER.info("start add in DAO");
        isNull(beans, "add(List<Voucher> beans)");
        for (Voucher voucher : beans) {
            isNull(voucher, "add(List<Voucher> beans)");
            if (!contains(voucher)) {
                vouchers.add(voucher);
            } else {
                LOGGER.warn("Voucher already exist");
            }
        }
    }

    /**
     * Add to saved list list of beans.
     * @param      beans to be saved.
     * @throws DAOException if beans are not exist or empty.
     * @since 1.0
     */
    @Override
    public void add(final List<Voucher> beans) throws DAOException {
        add(beans.toArray(new Voucher[beans.size()]));
    }

    /**
     * Resave list that are saved in DAO to list that is get in params
     * @param      beans to be resaved.
     * @throws DAOException if beans are not exist or empty.
     * @since 1.0
     */
    @Override
    public void update(final List<Voucher> beans) throws DAOException {
        LOGGER.info("start update in DAO");
        isNull(beans, "update(List<Voucher> beans)");
        for (Voucher voucher : beans) {
            isNull(voucher, "update(List<Voucher> beans)");
        }
        vouchers = new ArrayList<>(beans);
    }

    /**
     * Delete all beans that are saved in dao list.
     * @since 1.0
     */
    @Override
    public void delete() {
        LOGGER.info("start delete in DAO");
        vouchers = new ArrayList<>();
    }

    /**
     * Delete only beans that are saved in dao list now.
     * @param      beans  array to be deleted.
     * @throws DAOException if beans are not exist or empty.
     * @since 1.0
     */
    @Override
    public void delete(final Voucher... beans) throws DAOException {
        LOGGER.info("start delete in DAO");
        isNull(beans, "delete(Voucher... beans)");
        for (Voucher voucher : beans) {
            if (contains(voucher)) {
                vouchers.remove(voucher);
            } else {
                LOGGER.warn("No such Voucher on Disk");
            }
        }
    }

    /**
     * Delete only beans that are saved in dao list now.
     * @param      beans list to be deleted.
     * @throws DAOException if beans are not exist or empty.
     * @since 1.0
     */
    @Override
    public void delete(final List<Voucher> beans) throws DAOException {
        delete(beans.toArray(new Voucher[beans.size()]));
    }

    /**
     * Return the list of beans that are saved in dao now.
     * No changes with dao.
     * @return list of beans.
     * @throws DAOException if result are not exist or empty.
     * @since 1.0
     */
    @Override
    public List<Voucher> get() throws DAOException {
        LOGGER.info("start get in DAO");

        List<Voucher> result = new ArrayList<>(vouchers);
        if (result.size() == 0) {
            LOGGER.warn("zero size list in List<Voucher> get()");
            throw new DAOException();
        }
        return result;
    }

    /**
     * Check if list contains param.
     * @param searchedVoucher that is checked.
     * @return true if contain and false if not.
     * @since 1.0
     */
    private boolean contains(final Voucher searchedVoucher) {
        for (Voucher voucher : vouchers) {
            if (voucher.equals(searchedVoucher)) {
                return true;
            }
        }
        return false;
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
}
