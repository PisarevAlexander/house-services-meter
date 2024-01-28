package house_services_meter.controller;

import java.util.Scanner;

/**
 * The type Main controller
 */

public class MainController {

    static Scanner scanner = new Scanner(System.in);
    static UserController userController = new UserController();

    /**
     * Main menu.
     */

    public static void menu() {
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    userController.loginUser();
                    break;
                case 2:
                    userController.createUser();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

        private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Войти");
        System.out.println("2 - Зарегестрироваться");
        System.out.println("0 - Выход");
    }
}