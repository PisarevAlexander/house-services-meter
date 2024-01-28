package house_services_meter.service;

/**
 * The interface User service.
 */

public interface UserService {

    /**
     * Create user.
     * @param login    the login
     * @param password the password
     */

    void createUser(String login, String password);

    /**
     * Login user.
     * @param login    the login
     * @param password the password
     * @return the boolean
     */

    boolean loginUser(String login, String password);

    /**
     * Check admin role.
     * @param login the login
     * @return the boolean
     */

    boolean checkAdminRole(String login);

    /**
     * Add water meter.
     * @param login   the login
     * @param meter   the meter
     * @param date    the date
     * @param counter the counter
     */

    void addWaterMeter(String login, int meter, String date, String counter);

    /**
     * Get meters by month.
     * @param login the login
     * @param meter the meter
     * @param date  the date
     */

    void getMetersByMonth(String login, int meter, String date);

    /**
     * Get all history.
     * @param login the login
     * @param meter the meter
     */

    void getAllHistory(String login, int meter);
}
