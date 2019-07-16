package by.training.web_parsing.service;

public final class ServiceFabric {
    private ServiceFabric() {}
    private static Service service = new VoucherService();
    public static Service getService() { return service; }
}