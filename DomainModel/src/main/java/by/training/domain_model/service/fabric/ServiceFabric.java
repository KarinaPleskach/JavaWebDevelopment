package by.training.domain_model.service.fabric;

import by.training.domain_model.service.DiskService;
import by.training.domain_model.service.impl.DiskServiceImpl;

public final class ServiceFabric {
    private static DiskService service = new DiskServiceImpl();
    private ServiceFabric() {}
    public static DiskService getService() {
        return service;
    }
}
