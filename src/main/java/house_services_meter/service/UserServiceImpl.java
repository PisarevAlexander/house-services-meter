package house_services_meter.service;

import house_services_meter.model.Role;
import house_services_meter.model.User;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * The type User service.
 */

public class UserServiceImpl implements UserService {

    private final Map<String, User> users;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.yyyy");

    /**
     * Instantiates a new User service.
     */

    public UserServiceImpl() {
        this.users = new HashMap<>();
        User admin = new User("admin", "admin");
        admin.setRole(Role.ADMIN);
        users.put("admin", admin);
    }

    /**
     * Create user.
     * @param login    the login
     * @param password the password
     */

    @Override
    public void createUser(String login, String password) {
        if (users.containsKey(login)) {
            System.out.println("Логин уже занят, придумайте другой");
            return;
        }

        users.put(login, new User(login, password));
        System.out.println("Создан пользователь " + login + " " + password);
    }

    /**
     * Login user.
     * @param login    the login
     * @param password the password
     * @return the boolean
     */

    @Override
    public boolean loginUser(String login, String password) {
        User loginUser = users.get(login);
        if (loginUser == null) {
            System.out.println("Пользователь не найден");
            return false;
        } else if (!loginUser.getPassword().equals(password)) {
            System.out.println("Неверный пользователь или пароль");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check admin role.
     * @param login the login
     * @return the boolean
     */

    @Override
    public boolean checkAdminRole(String login) {
        User adminUser = users.get(login);
        return adminUser.getRole().equals(Role.ADMIN);
    }

    /**
     * Add water meter.
     * @param login   the login
     * @param meter   the meter
     * @param date    the date
     * @param counter the counter
     */

    @Override
    public void addWaterMeter(String login, int meter, String date, String counter) {
        User loginUser = users.get(login);
        YearMonth counterDate = YearMonth.parse(date, formatter);

        switch (meter) {
            case 1:
                if (loginUser.getColdWater().get(counterDate) == null) {
                    loginUser.addColdWaterMeter(counterDate, Integer.parseInt(counter));
                    System.out.println("Показания добавлены " + counterDate + " " + counter);
                    users.put(login, loginUser);
                    break;
                }
                System.out.println("Показания за " + counterDate + " уже были внесены");
                break;
            case 2:
                if (loginUser.getHotWater().get(counterDate) == null) {
                    loginUser.addHotWaterMeter(counterDate, Integer.parseInt(counter));
                    System.out.println("Показания добавлены " + counterDate + " " + counter);
                    users.put(login, loginUser);
                    break;
                }
                System.out.println("Показания за " + counterDate + " уже были внесены");
                break;
            case 3:
                if (loginUser.getHeating().get(counterDate) == null) {
                    loginUser.addHeatingMeter(counterDate, Integer.parseInt(counter));
                    System.out.println("Показания добавлены " + counterDate + " " + counter);
                    users.put(login, loginUser);
                    break;
                }
                System.out.println("Показания за " + counterDate + " уже были внесены");
                break;
            default:
                break;
        }
    }

    /**
     * Get meters by month.
     * @param login the login
     * @param meter the meter
     * @param date  the date
     */

    @Override
    public void getMetersByMonth(String login, int meter, String date) {
        User loginUser = users.get(login);

        if (loginUser != null) {
            YearMonth counterDate = YearMonth.parse(date, formatter);

            switch (meter) {
                case 1 -> System.out.println(loginUser.getColdWater().get(counterDate));
                case 2 -> System.out.println(loginUser.getHotWater().get(counterDate));
                case 3 -> System.out.println(loginUser.getHeating().get(counterDate));
            }
        } else {
            System.out.println("Пользователь не найден");
        }
    }

    /**
     * Get all history.
     * @param login the login
     * @param meter the meter
     */

    @Override
    public void getAllHistory(String login, int meter) {
        User loginUser = users.get(login);

        if (loginUser != null) {
            switch (meter) {
                case 1 -> System.out.println(loginUser.getColdWater());
                case 2 -> System.out.println(loginUser.getHotWater());
                case 3 -> System.out.println(loginUser.getHeating());
            }
        } else {
            System.out.println("Пользователь не найден");
        }
    }
}