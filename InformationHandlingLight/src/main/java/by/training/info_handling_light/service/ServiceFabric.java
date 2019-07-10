package by.training.info_handling_light.service;

public final class ServiceFabric {
    private ServiceFabric() {}
    private static Service service = new FileParserService();
    public static Service getService() { return service; }
}
