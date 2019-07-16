package by.training.web_parsing.dao;

import by.training.web_parsing.entity.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

class VoucherDAO implements DAO<Voucher> {

    private static final Logger LOGGER = LogManager.getLogger();

    private List<Voucher> vouchers = new ArrayList<>();

    @Override
    public void add(Voucher... beans) throws DAOException {
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

    @Override
    public void add(List<Voucher> beans) throws DAOException {
        add(beans.toArray(new Voucher[beans.size()]));
    }

    @Override
    public void update(List<Voucher> beans) throws DAOException {
        LOGGER.info("start update in DAO");
        isNull(beans, "update(List<Voucher> beans)");
        for (Voucher voucher : beans) {
            isNull(voucher, "update(List<Voucher> beans)");
        }
        vouchers = new ArrayList<>(beans);
    }

    @Override
    public void delete() {
        LOGGER.info("start delete in DAO");
        vouchers = new ArrayList<>();
    }

    @Override
    public void delete(Voucher... beans) throws DAOException {
        LOGGER.info("start delete in DAO");
        isNull(beans, "delete(Voucher... beans)");
        for(Voucher voucher : beans){
            if (contains(voucher)) {
                vouchers.remove(voucher);
            } else {
                LOGGER.warn("No such Voucher on Disk");
            }
        }
    }

    @Override
    public void delete(List<Voucher> beans) throws DAOException {
        delete(beans.toArray(new Voucher[beans.size()]));
    }

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

    private boolean contains(Voucher searchedVoucher) {
        for(Voucher voucher : vouchers){
            if(voucher.equals(searchedVoucher)) {
                return true;
            }
        }
        return false;
    }

    private void isNull (Object obj, String methodName) throws DAOException {
        if (obj == null) {
            String message = "Null object in " + methodName;
            LOGGER.warn(message);
            throw new DAOException(message);
        }
    }
}
