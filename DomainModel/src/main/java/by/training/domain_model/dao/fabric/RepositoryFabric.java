package by.training.domain_model.dao.fabric;

import by.training.domain_model.dao.Repository;
import by.training.domain_model.dao.repository.TXTRepository;

public class RepositoryFabric {
    private static Repository repository = new TXTRepository();
    private RepositoryFabric() {}
    public static Repository getRepository() {
        return  repository;
    }
}