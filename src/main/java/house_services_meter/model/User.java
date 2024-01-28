package house_services_meter.model;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The type User.
 */

public class User {

    private String login;
    private String password;
    private Role role;
    private Map<YearMonth, Integer> coldWater;
    private Map<YearMonth, Integer> hotWater;
    private Map<YearMonth, Integer> heating;

    /**
     * Instantiates a new User.
     * @param login    the login
     * @param password the password
     */

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = Role.USER;
        this.coldWater = new HashMap<>();
        this.hotWater = new HashMap<>();
        this.heating = new HashMap<>();
    }

    /**
     * Get password.
     * @return the password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Set role.
     * @param role the role
     */

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Get role.
     * @return the role
     */

    public Role getRole() {
        return role;
    }

    /**
     * Get cold water.
     * @return the cold water
     */

    public Map<YearMonth, Integer> getColdWater() {
        return coldWater;
    }

    /**
     * Add cold water meter.
     * @param date    the date
     * @param counter the counter
     */

    public void addColdWaterMeter(YearMonth date, Integer counter) {
        coldWater.put(date, counter);
    }

    /**
     * Get hot water.
     * @return the hot water
     */

    public Map<YearMonth, Integer> getHotWater() {
        return hotWater;
    }

    /**
     * Add hot water meter.
     * @param date    the date
     * @param counter the counter
     */

    public void addHotWaterMeter(YearMonth date, Integer counter) {
        hotWater.put(date, counter);
    }

    /**
     * Get heating.
     * @return the heating
     */

    public Map<YearMonth, Integer> getHeating() {
        return heating;
    }

    /**
     * Add heating meter.
     * @param date    the date
     * @param counter the counter
     */

    public void addHeatingMeter(YearMonth date, Integer counter) {
        heating.put(date, counter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) && password.equals(user.password) && role == user.role && Objects.equals(coldWater, user.coldWater) && Objects.equals(hotWater, user.hotWater) && Objects.equals(heating, user.heating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, role, coldWater, hotWater, heating);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}