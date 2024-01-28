package house_services_meter.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type User service test.
 */

class UserServiceTest {

    private static final UserService userService = new UserServiceImpl();


    /**
     * Sets up.
     */

    @BeforeAll
    static void setUp() {
        userService.createUser("123", "123");
    }

    /**
     * Create user with valid login.
     */

    @Test
    void createUserWithValidLogin() {
        userService.createUser("333", "333");

        assertTrue(userService.loginUser("333", "333"));
    }

    /**
     * Login user with valid login and password.
     */

    @Test
    void loginUserWithValidLoginAndPassword() {
        assertTrue(userService.loginUser("123", "123"));
    }

    /**
     * Login user with valid login and not valid password.
     */

    @Test
    void loginUserWithValidLoginAndNotValidPassword() {
        assertFalse(userService.loginUser("123", "321"));
    }

    /**
     * Login user with nor valid login.
     */

    @Test
    void loginUserWithNorValidLogin() {
        assertFalse(userService.loginUser("123444", "123"));
    }

    /**
     * Check valid admin role.
     */

    @Test
    void checkValidAdminRole() {
        assertTrue(userService.checkAdminRole("admin"));
    }

    /**
     * Check not valid admin role.
     */

    @Test
    void checkNotValidAdminRole() {
        assertFalse(userService.checkAdminRole("123"));
    }
}