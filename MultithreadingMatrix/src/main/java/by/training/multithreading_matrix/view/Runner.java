package by.training.multithreading_matrix.view;

import by.training.multithreading_matrix.controller.Controller;
import by.training.multithreading_matrix.controller.ControllerFabric;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final Controller controller = ControllerFabric.getController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write open and file path to initialize matrix\n" +
                "show to see the matrix\n" +
                "fill to fill main diagonal\n" +
                "exit to end");

        String response, request = "";

        while (!request.equalsIgnoreCase("exit")) {
            request = scanner.nextLine();
            response = controller.giveResponse(request);
            System.out.println(response);
        }
    }
}
