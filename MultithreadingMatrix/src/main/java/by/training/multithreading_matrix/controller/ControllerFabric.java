package by.training.multithreading_matrix.controller;

public class ControllerFabric {
    private ControllerFabric() {}
    private static Controller controller = new MatrixController();
    public static Controller getController() { return controller; }
}
