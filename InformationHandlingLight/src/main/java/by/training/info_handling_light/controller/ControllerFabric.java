package by.training.info_handling_light.controller;

public final class ControllerFabric {
    private ControllerFabric() {}
    private static Controller controller = new FileParserController();
    public static Controller getController() { return controller; }
}
