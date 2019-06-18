package by.training.dao;

import by.training.entity.Voucher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VoucherDAOTest {

    private static DAO<Voucher> dao;

    @Before
    public void before() {
        dao = DAOFabric.getDAO();
    }

    @Test(expected = DAOException.class)
    public void addNullTest() throws DAOException {
        dao.add((Voucher) null);
    }

    @Test(expected = DAOException.class)
    public void addNullElementsInArrayTest() throws DAOException {
        dao.add(new Voucher[]{(Voucher) null});
    }

    @Test(expected = DAOException.class)
    public void addNullElementsInListTest() throws DAOException {
        dao.add(new ArrayList<Voucher>(Arrays.asList((Voucher) null)));
    }

    @Test
    public void addNormalArray() throws DAOException {
        dao.delete();
        Voucher[] vouchers = new Voucher[]{new Voucher()};
        dao.add(vouchers);
        List<Voucher> result = dao.get();

        assertArrayEquals(vouchers, result.toArray());
    }

    @Test
    public void addNormalList() throws DAOException {
        dao.delete();
        List<Voucher> vouchers = new ArrayList<>();
        vouchers.add(new Voucher());
        dao.add(vouchers);
        List<Voucher> result = dao.get();

        assertArrayEquals(vouchers.toArray(), result.toArray());
    }

    @Test(expected = DAOException.class)
    public void updateNullTest() throws DAOException {
        dao.update(null);
    }

    @Test(expected = DAOException.class)
    public void updateNullElementsTest() throws DAOException {
        dao.update(new ArrayList<Voucher>(Arrays.asList((Voucher) null)));
    }
}