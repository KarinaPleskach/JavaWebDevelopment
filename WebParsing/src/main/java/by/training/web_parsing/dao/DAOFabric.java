package by.training.web_parsing.dao;

public final class DAOFabric {
    private static DAO dao = new VoucherDAO();
    private DAOFabric() {}
    public static DAO getDAO() {
        return  dao;
    }
}
