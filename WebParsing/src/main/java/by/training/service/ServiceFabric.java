package by.training.service;

public final class ServiceFabric {
    private ServiceFabric() {}
    private static Service service = new VoucherService();
    public static Service getService() { return service; }
}