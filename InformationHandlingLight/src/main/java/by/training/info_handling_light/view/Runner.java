package by.training.info_handling_light.view;

import by.training.info_handling_light.controller.Controller;
import by.training.info_handling_light.controller.ControllerFabric;

import java.util.Scanner;

//.\src\main\resources\test.txt
public class Runner {
    public static void main(String[] args) {
        final Controller controller = ControllerFabric.getController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write open file path to update initial text\n" +
                "show to see the text\n" +
                "sort paragraph|sentence|word to see sorted text and\n" +
                "exit to end");

        String response, request = "";

        while (!request.equalsIgnoreCase("exit")) {
            request = scanner.nextLine();
            response = controller.giveResponse(request);
            System.out.println(response);
        }
    }
}
