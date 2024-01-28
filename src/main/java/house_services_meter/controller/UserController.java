package house_services_meter.controller;

import house_services_meter.service.UserService;
import house_services_meter.service.UserServiceImpl;

import java.util.Scanner;

/**
 * The type User controller.
 */

public class UserController {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserServiceImpl();

    /**
     * Create user constructor.
     */

    public void createUser() {
        System.out.println("Введите логин");
        String login = scanner.next();
        System.out.println("Введите парель");
        String password = scanner.next();
        userService.createUser(login, password);
    }

    /**
     * Login user.
     */

    public void loginUser() {
        System.out.println("Введите логин");
        String login = scanner.next();
        System.out.println("Введите парель");
        String password = scanner.next();
        int command;
        int meter;

        while (userService.loginUser(login, password)) {

            if (userService.checkAdminRole(login)) {
                while (true) {
                    printAdminMenu();
                    String userLogin;
                    command = scanner.nextInt();
                    switch (command) {
                        case 1:
                            meter = printMeterMenu();
                            if (meter != 0) {
                                System.out.println("Введите логин пользователя");
                                userLogin = scanner.next();
                                System.out.println("Введите дану в формате мм.ГГГГ");
                                String date = scanner.next();
                                userService.getMetersByMonth(userLogin, meter, date);
                            }
                            break;
                        case 2:
                            meter = printMeterMenu();
                            if (meter != 0) {
                                System.out.println("Введите логин пользователя");
                                userLogin = scanner.next();
                                userService.getAllHistory(userLogin, meter);
                            }
                            break;
                        case 0:
                            return;
                        default:
                            System.out.println("Такой команды нет");
                    }
                }
            }

            printUserMenu();
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    meter = printMeterMenu();
                    if (meter != 0) {
                        System.out.println("Введите дану в формате мм.ГГГГ");
                        String date = scanner.next();
                        System.out.println("Введите показания");
                        String counter = scanner.next();
                        userService.addWaterMeter(login, meter, date, counter);
                    }
                    break;
                case 2:
                    meter = printMeterMenu();
                    if (meter != 0) {
                        System.out.println("Введите дану в формате мм.ГГГГ");
                        String date = scanner.next();
                        userService.getMetersByMonth(login, meter, date);
                    }
                    break;
                case 3:
                    meter = printMeterMenu();
                    if (meter != 0) {
                        userService.getAllHistory(login, meter);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    private void printUserMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Внести показания");
        System.out.println("2 - Посмотреть показания за месяц");
        System.out.println("3 - Посмотреть историю показаний");
        System.out.println("0 - Выход");
    }

    private int printMeterMenu() {
        while (true) {
            System.out.println("1 - Холодная вода");
            System.out.println("2 - Горячей вода");
            System.out.println("3 - Отопление");
            System.out.println("0 - Выход");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 0:
                    return 0;
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    private void printAdminMenu() {
        System.out.println("У вас права админимтратора. Что вы хотите сделать?");
        System.out.println("1 - Посмотреть показания пользователя за месяц");
        System.out.println("2 - Посмотреть историю показаний пользователя");
        System.out.println("0 - Выход");
    }

}