package by.training.multithreading_matrix.service;

public final class ServiceFabric {
    private ServiceFabric() {}
    private static Service service = new MatrixService();
    public static Service getService() { return service; }
}