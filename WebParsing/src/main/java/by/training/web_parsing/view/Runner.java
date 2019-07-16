package by.training.web_parsing.view;

import by.training.web_parsing.controller.Controller;
import by.training.web_parsing.controller.ControllerFabric;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
//.\src\main\resources\tourist_vouchers.xml
public class Runner {
    public static void main(String[] args) {
        final Controller controller = ControllerFabric.getController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write parse method name and file path to update initial vouchers\n" +
                "show to see the vouchers\n" +
                "exit to end");

        String response, request = "";

        while (!request.equalsIgnoreCase("exit")) {
            request = scanner.nextLine();
            response = controller.giveResponse(request);
            System.out.println(response);
        }

//        String[] locales = Locale.getISOCountries();
//
//        for (String countryCode : locales) {
//
//            Locale obj = new Locale("", countryCode);
//
//            System.out.println("Country Code = " + obj.getCountry()
//                    + ", Country Name = " + obj.getDisplayCountry());
//
//        }

//        Locale bel = new Locale("", "BY");
//        System.out.println(bel.getDisplayCountry());
    }
}
