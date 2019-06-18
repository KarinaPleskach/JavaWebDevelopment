package by.training.controller;

public final class ControllerFabric {
    private ControllerFabric() {}
    private static Controller controller = new VoucherController();
    public static Controller getController() { return controller; }
}